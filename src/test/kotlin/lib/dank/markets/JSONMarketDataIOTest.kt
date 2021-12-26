package lib.dank.markets

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.io.JSONMarketDataIO
import lib.dank.markets.io.toJSONArray
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class JSONMarketDataIOTest {

    private val mockParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2021-01-01",
        true
    )
    private val jsonFileName: String = "market_data_febd073d-b727-4258-9a17-f5b31c96b750.json"

    private var mockJSONMarketData: MutableList<JSONMarketData> = mutableListOf()
    private val mockProvider: PolygonDataProvider = mock()

    @BeforeAll
    fun setup() {
        whenever(mockProvider.ticker).thenReturn("AAPL")
        whenever(mockProvider.adapter).thenReturn(PolygonDataAdapter())
        whenever(mockProvider.client).thenReturn(PolygonClient())

    }

    @Test
    fun write() {
        assertEquals(true, JSONMarketDataIO(
            mockProvider.adapter.from(
                mockProvider.client.rest.getAggregatesBlocking(mockParameters), mockParameters)).write())
    }

    @Test
    fun read() {
        // To an Analysis Library [to conversions are compatible with analysis/indicators]
        mockJSONMarketData = JSONMarketDataIO(jsonFileName = jsonFileName).read(aggregatesParams = mockParameters)

        assertEquals(5000, mockJSONMarketData.size)
        assertEquals(5000, mockJSONMarketData.toJSONArray().length())
    }

    @Test
    fun toBarSeries() {
        /**
         * .2 seconds :O
         */
        assertEquals(5000, JSONMarketDataIO(jsonFileName = jsonFileName).toBarSeries().barCount)
    }
}