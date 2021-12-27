package lib.dank.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.analysis.ta.ta4j.Indicators
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.io.MarketDataIO
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

/**
 * Base Conditions Tests
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class CloseConditionsTest {

    /**
     * - Market Data Raw
     */
    private val mockAggregates: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockParameters: AggregatesParameters = mock()
    private var mockIndicators: Indicators = mock()

    private val adapter: MarketDataAdapter = BaseMarketDataAdapter()
    private val marketDataIO = MarketDataIO(jsonFileName = "market_data_ff012a7d-d7c6-4afa-84aa-38a67e363bfb.json")
    private var marketDataList: MutableList<MarketData> = mutableListOf()

    @BeforeAll
    fun setUp() {

//        "AAPL",
//        1,
//        "minute",
//        "2019-01-01",
//        "2020-01-01",
//        true


    }

    @Test
    fun indicatorsInstantiation() {
        val data = adapter.convert(
            mockAggregates,
            mockParameters
        )

        assertEquals(mockIndicators.close::class.java, Close(data)::class.java)
    }

    @Test
    fun conditionsInstantiations() {
        //assertEquals(mockIndicators.close.conditions::class.java, )
    }

    @Test
    fun isRising() {
        val data = adapter.convert(
            mockAggregates,
            mockParameters
        )

        whenever(mockIndicators.close).thenReturn(Close(data))

        whenever(mockIndicators.close.checkConditionZoned {
            mockIndicators.close.conditions.isRising()
        }).then {
            "Mock called with arguments: " + it.arguments
        }
    }

    @Test
    fun isFalling() {
    }

    @Test
    fun isOver() {
    }

    @Test
    fun isUnder() {
    }

    @Test
    fun crossOver() {
    }

    @Test
    fun crossUnder() {
    }

    @Test
    fun pivotUp() {
    }

    @Test
    fun pivotDown() {
    }

    @Test
    fun getMarketDataList() {
    }
}

//        whenever(mockBarSeries.getBar(0).openPrice.doubleValue()).thenReturn(40.0)
//        whenever(mockBarSeries.getBar(0).closePrice.doubleValue()).thenReturn(60.0)
//        whenever(mockBarSeries.getBar(0).lowPrice.doubleValue()).thenReturn(20.0)
//        whenever(mockBarSeries.getBar(0).highPrice.doubleValue()).thenReturn(80.0)
//        whenever(mockBarSeries.getBar(0).volume.doubleValue()).thenReturn(1000.50)
//        whenever(mockBarSeries.getBar(0).amount.doubleValue()).thenReturn(55.2)
