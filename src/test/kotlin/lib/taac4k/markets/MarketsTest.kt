package lib.dank.markets

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.polygon.Polygon
import lib.dank.markets.polygon.PolygonClient
import lib.dank.markets.polygon.PolygonDataProvider
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

/**
 * What are we tryna test?
 *
 *  - Check to see if the root markets object properly builds.
 *
 *  Success :)
 */
@ExtendWith(MockitoExtension::class)
internal class MarketsTest {

    private val markets: Markets = mock()

    @Test
    fun getTicker() {
        whenever(markets.ticker).thenReturn("AAPL")
        assertEquals(markets.ticker, "AAPL")
    }

    @Test
    fun getPolygon() {
        whenever(markets.polygon).thenReturn(Polygon())
        assertEquals(markets.polygon::class.java, Polygon::class.java)
        assertEquals(markets.polygon.client::class.java, PolygonClient::class.java)
        assertEquals(markets.polygon.adapter::class.java, BaseMarketDataAdapter::class.java)
        //@See [PolygonDataProviderTest]
        assertEquals(markets.polygon.provider::class.java, PolygonDataProvider::class.java)
        assertEquals(markets.polygon.ticker, "AAPL")
    }
}