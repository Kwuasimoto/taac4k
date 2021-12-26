package lib.dank.markets

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.io.MarketDataIO
import lib.dank.markets.polygon.PolygonClient
import lib.dank.markets.polygon.PolygonDataAdapter
import lib.dank.markets.polygon.PolygonDataProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.ZonedDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class MarketDataIOTest {

    private val mockParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2021-01-01",
        true
    )
    private val jsonFileName: String = "market_data_febd073d-b727-4258-9a17-f5b31c96b750.json"

    private val mockAggregates: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockProvider: PolygonDataProvider = mock()

    @BeforeAll
    fun setup() {
        whenever(mockProvider.ticker).thenReturn("AAPL")
        whenever(mockProvider.adapter).thenReturn(PolygonDataAdapter())
        whenever(mockProvider.client).thenReturn(PolygonClient())

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
                ),
                AggregateDTO(
                    "AAPL",
                    800.50,
                    51.2,
                    35.0,
                    55.0,
                    18.0,
                    75.0,
                    ZonedDateTime.now().toEpochSecond()
                )
            )
        )
    }

    @Test
    fun write() {
        assertEquals(true, MarketDataIO(
            mockProvider.adapter.from(
                mockProvider.client.rest.getAggregatesBlocking(mockParameters), mockParameters)).write())
    }

    @Test
    fun read() {
        val readData = MarketDataIO(jsonFileName = jsonFileName)
                .read(aggregatesParams = mockParameters)
        println(readData)
    }

    @Test
    fun toBarSeries() {
        assertEquals(5000, MarketDataIO(jsonFileName = jsonFileName).toBarSeries().barCount)
    }
}