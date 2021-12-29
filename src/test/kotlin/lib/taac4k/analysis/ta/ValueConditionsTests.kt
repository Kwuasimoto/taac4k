package lib.taac4k.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData
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
internal class ValueConditionsTests {

    /**
     * - Market Data Raw
     */

    private val mockIndicatorFactory: IndicatorFactory = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private var appleDataList: MutableList<MarketData> = MarketDataIO(jsonFileName = "apple_data_2019.json").read()
    private var tslaDataList: MutableList<MarketData> = MarketDataIO(jsonFileName = "tsla_data_2019.json").read()
    private var appleCloseIndicator: Close = mock()
    private var tslaCloseIndicator: Close = mock()

    @BeforeAll
    fun setUp() {
        /**
         * How to Use the taac4k Conditions Module.
         * 1. Prep Data (Look at IO Above, Or PolygonDataProviderTests),
         * 2. Use factory to create an indicator
         * 3. Check Conditions,
         * 4. Success!
         */


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

    @Test
    fun isRising() {
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
    fun crossOverTarget() {
        assertEquals(true,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.crossOver(494.99, 10) }.asBoolean)
        assertEquals(false,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.crossOver(494.99, 4) }.asBoolean)
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
