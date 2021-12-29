package lib.taac4k.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.factory.BaseMarketDataFactory
import lib.taac4k.markets.data.io.MarketDataIO
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

    private val mockIndicatorFactory: BaseConditionalIndicatorFactory = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val adapter: MarketDataAdapter = BaseMarketDataAdapter()
    private val appleDataIO = MarketDataIO(jsonFileName = "apple_data_2019.json")
    private val tslaDataIO = MarketDataIO(jsonFileName = "tsla_data_2019.json")
    private var appleDataList: MutableList<MarketData> = mutableListOf()
    private var tslaDataList: MutableList<MarketData> = mutableListOf()
    private var fakeDataList: MutableList<MarketData> = mutableListOf()
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
         * 2. Use [MutableList] of [MarketData] with [BaseConditionalIndicatorFactory] functions to make [Close]
         */
        appleCloseIndicator = BaseConditionalIndicatorFactory().close(appleDataList)
        tslaCloseIndicator = BaseConditionalIndicatorFactory().close(tslaDataList)

        /**
         * 3. TESTS
         */

        /**
         * 4. SOON
         */
    }

    @Test
    fun factoryFunctions() {
        assertEquals(mockIndicatorFactory::class.java, BaseConditionalIndicatorFactory::class.java)
        assertEquals(mockIndicatorFactory.close(appleDataList)::class.java, Close::class.java)
    }

    /**
     * Data Prep Tests
     */
    @Test
    fun convertMarketListToBarSeries() {
        val marketDataList = appleDataIO.read()
        val barSeries = adapter.toBarSeries(marketDataList)

        assertEquals(5000, barSeries.barCount)
    }

    @Test
    fun convertBarSeriesToMarketList() {
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
            appleCloseIndicator.check { appleCloseIndicator.conditions.isRising() }.asBoolean)
        assertEquals(false,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.isRising() }.asBoolean)
    }

    @Test
    fun isRisingWithIndex() {
        assertEquals(
            false,
            appleCloseIndicator.check { appleCloseIndicator.conditions.isRising(leftBarIndex = appleDataList.size - 5) }.asBoolean
        )
        assertEquals(
            true,
            appleCloseIndicator.check { appleCloseIndicator.conditions.isRising(leftBarIndex = appleDataList.size - 2) }.asBoolean
        )
    }

    @Test
    fun isFalling() {
        assertEquals(false,
            appleCloseIndicator.check { appleCloseIndicator.conditions.isFalling() }.asBoolean)
    }

    @Test
    fun isOver() {
        assertEquals(true,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.isOver(appleDataList) }.asBoolean)
        assertEquals(false,
            tslaCloseIndicator.check { appleCloseIndicator.conditions.isOver(tslaDataList) }.asBoolean)
    }


    @Test
    fun isOverWithIndex() {
        /**
         * Compare a list to itself,
         */
        assertEquals(
            true,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.isOver(
                    appleDataList,
                    comparableValueIndex = appleDataList.size - 10
                )
            }.asBoolean
        )
    }

    @Test
    fun isUnder() {
        assertEquals(false,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.isUnder(appleDataList) }.asBoolean)
        assertEquals(true,
            tslaCloseIndicator.check { appleCloseIndicator.conditions.isUnder(tslaDataList) }.asBoolean)
    }

    /**
     * Check Crossover conditions
     */
    @Test
    fun crossOverOtherData() {
        // Create a line to cross
        for (i in 0 until 100)
            fakeDataList.add(BaseMarketDataFactory().builder.close(494.99).build())

        // Bar is not above target
        assertEquals(true,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 21)
            }.asBoolean)

        // Bar is already above target
        assertEquals(false,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 15)
            }.asBoolean)

        fakeDataList = mutableListOf()
    }

    @Test
    fun crossOverTarget() {
        assertEquals(true,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.crossOver(494.99, 10) }.asBoolean)
        assertEquals(false,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.crossOver(494.99, 4) }.asBoolean)
    }

    @Test
    fun crossUnderOtherData() {
        // Create a line to cross
        for (i in 0 until 100)
            fakeDataList.add(BaseMarketDataFactory().builder.close(303.24).build())

        // Bar is not above target
        assertEquals(true,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 9)
            }.asBoolean)

        // Bar is already under comparable value
        assertEquals(false,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 2)
            }.asBoolean)

        fakeDataList = mutableListOf()
    }

    @Test
    fun crossUnderTarget() {
        // Bar already above target
        assertEquals(false,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.crossUnder(303.24, 10)
            }.asBoolean)
        // Has a crossover
        assertEquals(true,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.crossUnder(303.24, 9)
            }.asBoolean)
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
