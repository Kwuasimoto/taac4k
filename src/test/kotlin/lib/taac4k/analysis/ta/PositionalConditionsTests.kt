package lib.taac4k.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.factory.BaseMarketDataFactory
import lib.taac4k.markets.data.io.MarketDataIO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
class PositionalConditionsTests {

    private var appleDataList: MutableList<MarketData> = MarketDataIO(jsonFileName = "apple_data_2019.json").read()
    private var tslaDataList: MutableList<MarketData> = MarketDataIO(jsonFileName = "tsla_data_2019.json").read()
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

    /**
     * Check CROSSOVER OTHER DATA Conditions
     */
    @Test
    fun crossOverOtherDataWithIndex() {
        // Create a line to cross
        for (i in 0 until 100)
            fakeDataList.add(BaseMarketDataFactory().builder.close(494.99).build())

        // Bar is not above target
        Assertions.assertEquals(
            true,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 21)
            }.asBoolean
        )

        // Bar is already above target
        Assertions.assertEquals(
            false,
            tslaCloseIndicator.check {
                tslaCloseIndicator.conditions.crossOver(fakeDataList, startValueIndex = tslaDataList.size - 15)
            }.asBoolean
        )

        fakeDataList = mutableListOf()
    }


    @Test
    fun crossUnderOtherData() {
        // Create a line to cross
        for (i in 0 until 100)
            fakeDataList.add(BaseMarketDataFactory().builder.close(303.24).build())

        // Bar is not above target
        Assertions.assertEquals(
            true,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 9)
            }.asBoolean
        )

        // Bar is already under comparable value
        Assertions.assertEquals(
            false,
            appleCloseIndicator.check {
                appleCloseIndicator.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 2)
            }.asBoolean
        )

        fakeDataList = mutableListOf()
    }

    @Test
    fun isOverOtherData() {
        Assertions.assertEquals(
            true,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.isOver(appleDataList) }.asBoolean
        )
        Assertions.assertEquals(
            false,
            tslaCloseIndicator.check { appleCloseIndicator.conditions.isOver(tslaDataList) }.asBoolean
        )
    }


    @Test
    fun isOverOtherDataWithIndex() {
        Assertions.assertEquals(
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
    fun isUnderOtherData() {
        Assertions.assertEquals(
            false,
            tslaCloseIndicator.check { tslaCloseIndicator.conditions.isUnder(appleDataList) }.asBoolean
        )
        Assertions.assertEquals(
            true,
            tslaCloseIndicator.check { appleCloseIndicator.conditions.isUnder(tslaDataList) }.asBoolean
        )
    }

}