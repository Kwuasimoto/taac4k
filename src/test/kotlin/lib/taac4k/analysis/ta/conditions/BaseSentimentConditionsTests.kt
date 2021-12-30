package lib.taac4k.analysis.ta.conditions

import com.nhaarman.mockitokotlin2.mock
import lib.taac4k.analysis.ta.ta4j.indicators.RSI
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.io.MarketDataIO
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
class BaseSentimentConditionsTests {

    private var aaplDataList: MutableList<MarketData> = MarketDataIO(jsonFileName = "aapl_data_2019.json").readJSON()
    private var tslaDataList: MutableList<MarketData> = MarketDataIO(jsonFileName = "tsla_data_2019.json").readJSON()
    private var aaplRSI: RSI = mock()
    private var tslaRSI: RSI = mock()

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
        aaplRSI = RSI(Close(aaplDataList))
        tslaRSI = RSI(Close(tslaDataList))


        /**
         * 3. TESTS
         */
    }

    @Test
    fun isOverbought() {
        // Check 3 RSI Bars in Console
        for (i in 0 until 100) {
            val aaplRSIVal = aaplRSI.rawIndicator.getValue(aaplRSI.values.barCount - (i + 1)).intValue()
            val tslaRSIVal = tslaRSI.rawIndicator.getValue(tslaRSI.values.barCount - (i + 1)).intValue()
            println(
                "Is aaplRSI Overbought? val:${aaplRSIVal}:${
                    aaplRSI.conditions.isOverbought(aaplRSIVal)
                }"
            )
            println(
                "Is tslaRSI Overbought? val:${tslaRSIVal}:${
                    tslaRSI.conditions.isOverbought(tslaRSIVal)
                }"
            )
        }
    }

    @Test
    fun isOversold() {
        for (i in 0 until 100) {
            val aaplRSIVal = aaplRSI.rawIndicator.getValue(aaplRSI.values.barCount - (i + 1)).intValue()
            val tslaRSIVal = tslaRSI.rawIndicator.getValue(tslaRSI.values.barCount - (i + 1)).intValue()

            println("Is aaplRSI Oversold? val:${aaplRSIVal}:${aaplRSI.conditions.isOversold(aaplRSIVal)}")
            println("Is tslaRSI Oversold? val:${tslaRSIVal}:${tslaRSI.conditions.isOversold(tslaRSIVal)}")
        }
    }

    @Test
    fun isOverThreshold() {
        for (i in 0 until 100) {
            val aaplRSIVal = aaplRSI.rawIndicator.getValue(aaplRSI.values.barCount - (i + 1)).intValue()
            val tslaRSIVal = tslaRSI.rawIndicator.getValue(tslaRSI.values.barCount - (i + 1)).intValue()
            println(
                "Is aaplRSI overThreshold? val:${aaplRSIVal}:${
                    aaplRSI.conditions.isOverThreshold(aaplRSIVal)
                }"
            )
            println(
                "Is tslaRSI overThreshold? val:${tslaRSIVal}:${
                    tslaRSI.conditions.isOverThreshold(tslaRSIVal)
                }"
            )
        }
    }

//    @Test
//    fun testIndicatorINData() {
//        /**
//         * Data Is clean, idk why rsi does weird things
//         */
//        for(i in 0 until 100){
//            println("[${i + 1}]close : value = " + appleDataList[i].ohlcv[OHLCV.CLOSE])
//            println("[${i + 1}]open : value = " + appleDataList[i].ohlcv[OHLCV.OPEN])
//            println("[${i + 1}]high : value = " + appleDataList[i].ohlcv[OHLCV.HIGH])
//            println("[${i + 1}]low : value = " + appleDataList[i].ohlcv[OHLCV.LOW])
//            println("[${i + 1}]vwap : value = " + appleDataList[i].ohlcv[OHLCV.VWAP])
//        }
//    }
//
//    @Test
//    fun testIndicatorOUTData() {
//        println("apple RSI barcount ${aaplRSI.values.barCount}")
//        for(i in 0 until aaplRSI.values.barCount) {
//            println("[${i + 1}]rsi : value = " + aaplRSI.rawIndicator
//                .getValue(aaplRSI.values.barCount - (i + 1)).doubleValue()
//            )
//        }
//    }


}