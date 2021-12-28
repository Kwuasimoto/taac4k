package lib.taac4k.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.io.MarketDataIO
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
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
    private val mockIndicatorFactory: IndicatorFactory = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)

    private val aggregatesParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2021-01-01",
        true,
    )

    private val adapter: BaseMarketDataAdapter = MarketDataAdapter()
    private val marketDataIO = MarketDataIO(jsonFileName = "market_data_61840a89-bccf-4e14-8da7-2da23ea42a6c.json")
    private var marketDataList: MutableList<MarketData> = mutableListOf()
    private var close: Close = mock()

    @BeforeAll
    fun setUp() {
        /**
         * How to Use the taac4k Conditions Module.
         * 1. Prep Data,
         * 2. Use factory to create an indicator
         * 3. Check Conditions,
         * 4. Success!
         */

        /**
         * 1. Prepare [MutableList] of [MarketData]
         */
        marketDataList = marketDataIO.read()

        /**
         * 2. Use [MutableList] of [MarketData] with [IndicatorFactory] functions to make [Close]
         */
        close = IndicatorFactory().close(marketDataList)


        /**
         * 3. TESTS
         */

        /**
         * 4. SOON
         */
    }

    @Test
    fun factoryFunctions() {
        assertEquals(mockIndicatorFactory::class.java, IndicatorFactory::class.java)
        assertEquals(mockIndicatorFactory.close(marketDataList)::class.java, Close::class.java)
    }

    /**
     * Data Prep Tests
     */
    @Test
    fun adaptMarketListToBarSeries() {
        val marketDataList = marketDataIO.read()
        val barSeries = adapter.toBarSeries(marketDataList)

        assertEquals(5000, barSeries.barCount)
    }

    @Test
    fun adaptBarSeriesToMarketList() {
        val newSeries = marketDataIO.toBarSeries()
        val marketDataList = adapter.convert(newSeries)

        assertEquals(5000, marketDataList.size)
    }

    /**
     * Base Conditions Tests
     */
    @Test
    fun isRising() {
//        println(close)
//        assertEquals(true,
//            close.check {
//                close.conditions.isRising()
//            }.asBoolean)

        assertEquals(false,
            close.check {
                close.conditions.isRising(leftBarIndex = 5)
            }.asBoolean)

    }

    @Test
    fun isFalling() {
        assertEquals(false,
            close.check{
                close.conditions.isFalling() // && another indicators condition :D
            }.asBoolean)
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
