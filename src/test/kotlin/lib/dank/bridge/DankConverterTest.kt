package lib.dank.bridge

import com.nhaarman.mockitokotlin2.mock
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.io.JSONMarketDataIO
import lib.dank.markets.io.toJSONArray
import lib.dank.markets.polygon.PolygonDataProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries

/**
 * For Polygon to MarketData Tests @See [PolygonDataProdiverTest]
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class DankConverterTest {

    private val mockConverter: DankConverter = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private var mockJSONMarketData: MutableList<JSONMarketData> = mutableListOf()
    private val mockBarSeries: BarSeries = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)

    private val polygonDataProvider: PolygonDataProvider = PolygonDataProvider()
    private val ta4j: TA4JAdapter = TA4JAdapter()

    private val jsonFileName: String = "market_data_febd073d-b727-4258-9a17-f5b31c96b750.json"
    private val jsonIO: JSONMarketDataIO = JSONMarketDataIO()

    /**
     * Example of params used to fetch JSON Data
     */
    private val aggregatesParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2020-01-01",
        true
    )

    @Test
    fun fromMarketDataToTA4J() {
        // To an Analysis Library [to conversions are compatible with analysis/indicators]
        mockJSONMarketData = jsonIO.read(aggregatesParams = aggregatesParameters)

        assertEquals(5000, mockJSONMarketData.size)
        assertEquals(5000, mockJSONMarketData.toJSONArray().length())
    }


}