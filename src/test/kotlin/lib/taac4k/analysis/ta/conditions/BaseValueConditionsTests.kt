package lib.taac4k.analysis.ta.conditions

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.io.MarketDataIO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

/**
 * Base Conditions Tests
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class BaseValueConditionsTests {

    /**
     * - Market Data Raw
     */
    private var appleDataList: MutableList<MarketData> = MarketDataIO(fileName = "aapl_data_2019.json").readJSON()
    private var tslaDataList: MutableList<MarketData> = MarketDataIO(fileName = "tsla_data_2019.json").readJSON()
    private var aaplClose: Close = mock()
    private var tslaClose: Close = mock()

    @BeforeAll
    fun setUp() {
        /**
         * How to Use the taac4k Conditions Module.
         * 1. Prep Data (Look at IO Above, Or PolygonDataProviderTests),
         * 2. Use factory to create an indicator
         * 3. Check Conditions
         */

        /**
         * 2. Use [MutableList] of [MarketData]
         */
        aaplClose = Close(appleDataList)
        tslaClose = Close(tslaDataList)

        /**
         * 3. TESTS
         */
    }

    @Test
    fun isRising() {
        for(i in 1 until aaplClose.marketDataList.size)
            println(i)

        assertEquals(true, aaplClose.conditions.isRising())
        assertEquals(false, tslaClose.conditions.isRising())
    }

    @Test
    fun isRisingWithIndex() {
        assertEquals(false, aaplClose.conditions.isRising(leftBarIndex = appleDataList.size - 5))
        assertEquals(true, aaplClose.conditions.isRising(leftBarIndex = appleDataList.size - 2))
    }

    @Test
    fun isFalling() {
        assertEquals(false, aaplClose.conditions.isFalling())
    }

    @Test
    fun crossOverTarget() {
        assertEquals(true, tslaClose.conditions.crossOver(494.99, 10))
        assertEquals(false, tslaClose.conditions.crossOver(494.99, 4))
        assertEquals(false, aaplClose.conditions.crossOver(494.99, 100))
    }

    @Test
    fun crossOverSeries() {
        assert(tslaClose.conditions.crossOver(aaplClose.marketDataList))
    }

    @Test
    fun crossUnderTarget() {
        // Bar already above target
        assertEquals(false, aaplClose.conditions.crossUnder(303.24, 10))
        // Has a crossover
        assertEquals(true, aaplClose.conditions.crossUnder(303.24, 9))
    }
}

