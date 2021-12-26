package lib.dank.bridge

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.markets.polygon.PolygonDataAdapter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries
import java.time.ZonedDateTime


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class DankConverterTest {

    private val mockConverter: DankConverter = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockAggregates: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockBarSeries: BarSeries = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val aggregatesParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2020-01-01",
        true
    )

    @BeforeAll
    fun setup() {
        whenever(mockConverter.polygonAdapter).thenReturn(PolygonDataAdapter())
        whenever(mockConverter.ta4jAdapter).thenReturn(TA4JAdapter())

        whenever(mockAggregates.results).thenReturn(
            listOf(
                AggregateDTO(
                    "AAPL",
                    1000.50,
                    55.2,
                    40.0,
                    60.0,
                    20.0,
                    80.0,
                    ZonedDateTime.now().toEpochSecond()
                )
            )
        )

        whenever(mockBarSeries.getBar(0).openPrice.doubleValue()).thenReturn(40.0)
        whenever(mockBarSeries.getBar(0).closePrice.doubleValue()).thenReturn(60.0)
        whenever(mockBarSeries.getBar(0).lowPrice.doubleValue()).thenReturn(20.0)
        whenever(mockBarSeries.getBar(0).highPrice.doubleValue()).thenReturn(80.0)
    }

    @Test
    fun fromPolygonToTA4J() {
        // To an Analysis Library [to conversions are compatible with analysis/indicators]
        val convertedBar = mockConverter.ta4jAdapter.toBarSeries(
            // From a MarketData Adapter [from conversions are compatible with Conditions]
            mockConverter.polygonAdapter.from(mockAggregates, aggregatesParameters)
        ).getBar(0)

        assertEquals(mockBarSeries.getBar(0).openPrice.doubleValue(), convertedBar.openPrice.doubleValue())
        assertEquals(mockBarSeries.getBar(0).closePrice.doubleValue(), convertedBar.closePrice.doubleValue())
        assertEquals(mockBarSeries.getBar(0).lowPrice.doubleValue(), convertedBar.lowPrice.doubleValue())
        assertEquals(mockBarSeries.getBar(0).highPrice.doubleValue(), convertedBar.highPrice.doubleValue())
    }
}