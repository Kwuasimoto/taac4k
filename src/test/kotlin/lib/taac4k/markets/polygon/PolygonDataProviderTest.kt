package lib.taac4k.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.MarketDataAdapter
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
internal class PolygonDataProviderTest {

    private val polygonDataProvider: PolygonDataProvider = PolygonDataProvider()
    private val aggregatesParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2021-01-01",
        true,
    )

    @BeforeAll
    fun setUp() {}

    @Test
    fun getTicker() {
        assertEquals(polygonDataProvider.ticker, "AAPL")
    }

    @Test
    fun getClient() {
        assertEquals(polygonDataProvider.client::class.java, PolygonClient::class.java)
    }

    @Test
    fun getAdapter() {
        assertEquals(polygonDataProvider.adapter::class.java, MarketDataAdapter::class.java)
    }

    /**
     * Test raw data fetch
     */
    @Test
    fun rawAggregates() {
        val rawAggregates = polygonDataProvider.client.rest.getAggregatesBlocking(aggregatesParameters)
        assertEquals(rawAggregates::class.java, AggregatesDTO::class.java)
        assertEquals(5000, rawAggregates.results.size)
    }

    /**
     * Prepped data for Conditions
     */
    @Test
    fun getMarketDataList() {
        val marketDataList = polygonDataProvider.getAggregates(1, "minute", "2019-01-01", limit = 100)
        assertEquals(100, marketDataList.size)
        assertEquals(MarketData::class.java, marketDataList[0]::class.java)
    }

    @Test
    fun getAggregatesToBarSeries() {
        val barSeries = polygonDataProvider.adapter.toBarSeries(
            polygonDataProvider.getAggregates(1, "minute", "2019-01-01")
        )

        println(barSeries)
    }
}