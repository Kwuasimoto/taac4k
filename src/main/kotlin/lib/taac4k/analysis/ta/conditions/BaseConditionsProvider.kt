package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

/**
 * ### Default Condition Supplier
 */

interface BaseConditionsProvider {
//    /**
//     *
//     */
//    fun barsSince condition: () -> ConditionAlertSupplier, length: Int): ConditionAlertSupplier

    val values: MarketDataValuesProvider

    fun percentChanged(

        change: Float,

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun isRising(

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun isFalling(

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun isOver(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun isUnder(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossOver(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossOver(
        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE
    ): Boolean

    fun crossUnder(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossUnder(

        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun highest(
        leftBarIndex: Int,
        rightBarIndex: Int,
    ): Boolean

    fun lowest(
        leftBarIndex: Int,
        rightBarIndex: Int
    ): Boolean

    fun pivotUp(

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 0,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean


    fun pivotDown(

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 0,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean

//
//    fun bullishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBullishDivergence(indicator: T): ConditionAlertSupplier
//
//    fun bearishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBearishDivergence(indicator: T): ConditionAlertSupplier
}