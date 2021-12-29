package lib.taac4k.markets

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.io.MarketDataIO
import lib.taac4k.markets.providers.polygon.PolygonClient
import lib.taac4k.markets.providers.polygon.PolygonDataProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class MarketDataIOTest {

    private val jsonFileName: String = "apple_data_2019.json"
    private var mockMarketData: MutableList<MarketData> = mutableListOf()
    private val mockProvider: PolygonDataProvider = mock()
    private val mockParameters: AggregatesParameters = AggregatesParameters(
        "TSLA",
        1,
        "minute",
        "2019-01-01",
        "2021-01-01",
        true
    )

    @BeforeAll
    fun setup() {
        whenever(mockProvider.ticker).thenReturn("TSLA")
        whenever(mockProvider.adapter).thenReturn(BaseMarketDataAdapter())
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