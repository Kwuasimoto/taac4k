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
    private val appleDataIO = MarketDataIO(jsonFileName = "apple_data_2019.json")
    private val tslaDataIO = MarketDataIO(jsonFileName = "tsla_data_2019.json")
    private var appleDataList: MutableList<MarketData> = mutableListOf()
    private var tslaDataList: MutableList<MarketData> = mutableListOf()
    private var appleCloseIndicator: Close = mock()
    private var tslaCloseIndicator: Close = mock()

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
        appleDataList = appleDataIO.read()
        tslaDataList = tslaDataIO.read()

        /**
         * 2. Use [MutableList] of [MarketData] with [IndicatorFactory] functions to make [Close]
         */
        appleCloseIndicator = IndicatorFactory().close(appleDataList)
        tslaCloseIndicator = IndicatorFactory().close(tslaDataList)

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
        assertEquals(mockIndicatorFactory.close(appleDataList)::class.java, Close::class.java)
    }

    /**
     * Data Prep Tests
     */
    @Test
    fun adaptMarketListToBarSeries() {
        val marketDataList = appleDataIO.read()
        val barSeries = adapter.toBarSeries(marketDataList)

        assertEquals(5000, barSeries.barCount)
    }

    @Test
    fun adaptBarSeriesToMarketList() {
        val newSeries = appleDataIO.toBarSeries()
        val marketDataList = adapter.convert(newSeries)

        assertEquals(5000, marketDataList.size)
    }

    /**
     * Base Conditions Tests
     */
    @Test
    fun isRising() {
//        println(close)
        assertEquals(true,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.isRising()
            }.asBoolean)
        assertEquals(false,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.isRising()
            }.asBoolean)
    }

    @Test
    fun isRisingWithIndex() {
        assertEquals(false,
            appleCloseIndicator.check {
                // marketDataList.size - 5 == (5000 - 5 = 4995 (4th bar to the left), close = 303.19)
                appleCloseIndicator.conditions.isRising(leftBarIndex = appleDataList.size - 5)
            }.asBoolean)

        assertEquals(true,
            appleCloseIndicator.check {
                // marketDataList.size - 2 == (5000 - 2 = 4998 (1 bar to the left))
                appleCloseIndicator.conditions.isRising(leftBarIndex = appleDataList.size - 2)
            }.asBoolean)
    }

    @Test
    fun isFalling() {
        assertEquals(false,
            appleCloseIndicator.check{
                appleCloseIndicator.conditions.isFalling() // && another indicators condition :D
            }.asBoolean)
    }

    @Test
    fun isOver() {
        assertEquals(true,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.isOver(appleDataList)
            }.asBoolean)
        assertEquals(false,
            tslaCloseIndicator.check { // xD
                // check if the apple data list is over tsla, not proper usage, but it exists lel
                appleCloseIndicator.conditions.isOver(tslaDataList)
            }.asBoolean)
    }


    @Test
    fun isOverWithIndex() {
        /**
         * Compare a list to itself,
         */
        assertEquals(true,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.isOver(
                    appleDataList, comparableIndex = appleDataList.size - 10
                )
            }.asBoolean)
    }

    @Test
    fun isUnder() {
        assertEquals(false,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.isUnder(appleDataList)
            }.asBoolean)
        assertEquals(true,
            tslaCloseIndicator.check { // xD
                // check if the apple data list is over tsla, not proper usage, but it exists lel
                appleCloseIndicator.conditions.isUnder(tslaDataList)
            }.asBoolean)
    }

    @Test
    fun crossOver() {
//        assertEquals(false,
//            tslaCloseIndicator.check {
//
//            }.asBoolean)

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
