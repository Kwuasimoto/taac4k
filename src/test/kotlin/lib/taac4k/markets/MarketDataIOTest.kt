package lib.dank.markets

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.io.MarketDataIO
import lib.dank.markets.polygon.PolygonClient
import lib.dank.markets.polygon.PolygonDataProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

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
    private val jsonFileName: String = "market_data_0ebb6f36-3c7e-4a43-9d2e-58cbf1848f24.json"

    private var mockMarketData: MutableList<MarketData> = mutableListOf()
    private val mockProvider: PolygonDataProvider = mock()

    @BeforeAll
    fun setup() {
        whenever(mockProvider.ticker).thenReturn("AAPL")
        whenever(mockProvider.adapter).thenReturn(BaseMarketDataAdapter())
        whenever(mockProvider.client).thenReturn(PolygonClient())

    }

    @Test
    fun write() {
        val ioData =
            mockProvider.adapter.convert(mockProvider.client.rest.getAggregatesBlocking(mockParameters), mockParameters)
        val io = MarketDataIO(ioData)

        assertEquals(true, io.write())
    }

    @Test
    fun read() {
        // To an Analysis Library [to conversions are compatible with analysis/indicators]
        mockMarketData = MarketDataIO(jsonFileName = jsonFileName).read(aggregatesParams = mockParameters)
        assertEquals(5000, mockMarketData.size)
    }


    @Test
    fun toBarSeries() {
        /**
         * .2 seconds :O
         */
        assertEquals(5000, MarketDataIO(jsonFileName = jsonFileName).toBarSeries().barCount)
    }
}