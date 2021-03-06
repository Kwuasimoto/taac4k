package lib.taac4k.analysis.ta.conditions

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.factory.BaseMarketDataBuilder
import lib.taac4k.markets.data.io.MarketDataIO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
class BasePositionalConditionsTests {

    private var appleDataList: MutableList<MarketData> = MarketDataIO(fileName = "aapl_data_2019.json").readJSON()
    private var tslaDataList: MutableList<MarketData> = MarketDataIO(fileName = "tsla_data_2019.json").readJSON()
    private var fakeDataList: MutableList<MarketData> = mutableListOf()
    private var aaplClose: Close = mock()
    private var tslaClose: Close = mock()

    @BeforeAll
    fun setUp() {
        /**
         * How to Use the taac4k Conditions Module.
         * 1. Prep Data,
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

    /**
     * Check CROSSOVER OTHER DATA Conditions
     */
    @Test
    fun crossOverOtherDataWithIndex() {
        val builder = BaseMarketDataBuilder()

        // Create a line to cross
        for (i in 0 until 100)
            fakeDataList.add(builder.close(494.99).build())

        // Bar is not above target
        Assertions.assertEquals(true,
            tslaClose.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 21)
        )
        // Bar is already above target
        Assertions.assertEquals(false,
            tslaClose.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 15)
        )

        // Bar is already above target
        Assertions.assertEquals(false,
            tslaClose.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 3)
        )

        fakeDataList = mutableListOf()
    }

    @Test
    fun crossUnderOtherData() {
        // Create a line to cross
        val builder = BaseMarketDataBuilder()

        for (i in 0 until 100)
            fakeDataList.add(builder.close(303.24).build())

        // Bar is not above target
        Assertions.assertEquals(true,
            aaplClose.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 9))
        // Bar is already under comparable value
        Assertions.assertEquals(false,
            aaplClose.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 2))

        fakeDataList = mutableListOf()
    }

    @Test
    fun isOverOtherData() {
        Assertions.assertEquals(true, tslaClose.conditions.isOver(appleDataList))
        Assertions.assertEquals(false, aaplClose.conditions.isOver(tslaDataList))
    }

    @Test
    fun isOverOtherDataWithIndex() {
        Assertions.assertEquals(true,
            aaplClose.conditions.isOver(
                appleDataList,
                comparableValueIndex = appleDataList.size - 10
        ))
    }

    @Test
    fun isUnderOtherData() {
        Assertions.assertEquals(false, tslaClose.conditions.isUnder(appleDataList))
        Assertions.assertEquals(true, aaplClose.conditions.isUnder(tslaDataList))
    }
}