package lib.taac4k.markets.polygon

import com.nhaarman.mockitokotlin2.mock
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

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

    private val aggregatesDTO: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val MarketDataList: LinkedList<MarketData> = mock()

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
    fun oneShotMarketDataList() {
        val mockResult = polygonDataProvider.getAggregates(1, "minute", "2019-01-01", limit = 100)
        assertEquals(100, mockResult.size)
        assertEquals(MarketData::class.java, mockResult[0]::class.java)
    }
}