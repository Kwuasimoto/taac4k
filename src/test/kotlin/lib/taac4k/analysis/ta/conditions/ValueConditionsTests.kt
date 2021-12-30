package lib.taac4k.analysis.ta.conditions

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.IndicatorFactory
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
    fun factoryFunctions() {
        assertEquals(mockIndicatorFactory::class.java, IndicatorFactory::class.java)
        assertEquals(mockIndicatorFactory.close(appleDataList)::class.java, Close::class.java)
    }

    @Test
    fun isRising() {
        assertEquals(true,
            aaplClose.check {
                aaplClose.conditions.isRising()
            }.asBoolean
        )
        assertEquals(false,
            tslaClose.check {
                tslaClose.conditions.isRising()
            }.asBoolean
        )
    }

    @Test
    fun isRisingWithIndex() {
        assertEquals(
            false,
            aaplClose.check {
                aaplClose.conditions.isRising(leftBarIndex = appleDataList.size - 5)
            }.asBoolean
        )
        assertEquals(
            true,
            aaplClose.check {
                aaplClose.conditions.isRising(leftBarIndex = appleDataList.size - 2)
            }.asBoolean
        )
    }

    @Test
    fun isFalling() {
        assertEquals(false,
            aaplClose.check { aaplClose.conditions.isFalling() }.asBoolean
        )
    }

    @Test
    fun crossOverTarget() {
        assertEquals(true,
            tslaClose.check {
                tslaClose.conditions.crossOver(494.99, 10)
            }.asBoolean
        )
        assertEquals(false,
            tslaClose.check {
                tslaClose.conditions.crossOver(494.99, 4)
            }.asBoolean
        )
    }

    @Test
    fun crossUnderTarget() {
        // Bar already above target
        assertEquals(false,
            aaplClose.check {
                aaplClose.conditions.crossUnder(303.24, 10)
            }.asBoolean
        )
        // Has a crossover
        assertEquals(true,
            aaplClose.check {
                aaplClose.conditions.crossUnder(303.24, 9)
            }.asBoolean
        )
    }
}

