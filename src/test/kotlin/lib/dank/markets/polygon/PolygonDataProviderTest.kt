package lib.dank.markets.polygon

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.experimental.toBarSeries
import lib.dank.markets.MarketDataJSON
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.ZonedDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class PolygonDataProviderTest {

    private var aggregatesParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2020-01-01",
        true
    )

    private val polygonDataProvider: PolygonDataProvider = mock()
    private val aggregatesDTO: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val marketDataJSONList: MutableList<MarketDataJSON> = mock()

    @BeforeAll
    fun setUp() {
        whenever(polygonDataProvider.ticker).thenReturn("AAPL")
        whenever(polygonDataProvider.adapter).thenReturn(PolygonDataAdapter())
        whenever(polygonDataProvider.client).thenReturn(PolygonClient())

        /**
         * Setup DTO for [useAdapter]
         */
        whenever(aggregatesDTO.results).thenReturn(
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
    }

    @Test
    fun getTicker() {
        assertEquals(polygonDataProvider.ticker, "AAPL")
    }

    @Test
    fun getClient() {
        assertEquals(polygonDataProvider.client::class.java, PolygonClient::class.java)
    }

    @Test
    fun rawAggregates() {
        assertEquals(
            polygonDataProvider.client.rest.getAggregatesBlocking(aggregatesParameters)::class.java,
            AggregatesDTO::class.java
        )
    }

    @Test
    fun useAdapter() {
        whenever(
            polygonDataProvider.adapter.from(AggregatesDTO(results = aggregatesDTO.results), aggregatesParameters)
                .toBarSeries().getBar(0).closePrice.doubleValue()
        ).thenReturn(60.0)
        whenever(
            polygonDataProvider.adapter.from(AggregatesDTO(results = aggregatesDTO.results), aggregatesParameters)
                .toBarSeries().getBar(0).lowPrice.doubleValue()
        ).thenReturn(20.0)
    }


    @Test
    fun oneStepToConversionExample() {

        /**
         * @DoAnalysis, Get Data back from analysis libs and check conditions :)
         */
    }


    @Test
    fun getAggregates() {

    }
}