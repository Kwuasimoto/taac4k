package lib.taac4k.markets

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.io.MarketDataIO
import lib.taac4k.markets.polygon.PolygonClient
import lib.taac4k.markets.polygon.PolygonDataProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class MarketDataIOTest {

    private val jsonFileName: String = "market_data_61840a89-bccf-4e14-8da7-2da23ea42a6c.json"
    private var mockMarketData: MutableList<MarketData> = mutableListOf()
    private val mockProvider: PolygonDataProvider = mock()
    private val mockParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2021-01-01",
        true
    )

    @BeforeAll
    fun setup() {
        whenever(mockProvider.ticker).thenReturn("AAPL")
        whenever(mockProvider.adapter).thenReturn(MarketDataAdapter())
        whenever(mockProvider.client).thenReturn(PolygonClient())
    }

    @Test
    fun write() {
        val marketDataList =
            mockProvider.adapter.convert(mockProvider.client.rest.getAggregatesBlocking(mockParameters), mockParameters)

        assertEquals(true, MarketDataIO(marketDataList).write())
    }

    @Test
    fun read() {
        mockMarketData = MarketDataIO(jsonFileName = jsonFileName).read()
        assertEquals(5000, mockMarketData.size)
    }


    @Test
    fun readToBarSeries() {
        assertEquals(5000, MarketDataIO(jsonFileName = jsonFileName).toBarSeries().barCount)
    }
}