package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.conditions.executor.ConditionsExecutor
import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValueSupplier

/**
 * ### Default Condition Supplier
 */

interface ConditionsProvider : MarketDataValueSupplier, ConditionsExecutor {
//    /**
//     *
//     */
//    fun barsSince condition: () -> ConditionAlertSupplier, length: Int): ConditionAlertSupplier

    var cachedBool: Boolean
    var cachedBarsLeft: Int;

    fun percentChanged(

        change: Float,

        leftBarIndex: Int = barCount - 2,
        rightBarIndex: Int = barCount - 1,

        leftBarOHLC: OHLCV = OHLCV.CLOSE,
        rightBarOHLC: OHLCV = OHLCV.CLOSE,

        ): Boolean

    fun isRising(

        leftBarIndex: Int = barCount - 2,
        rightBarIndex: Int = barCount - 1,

        leftBarOHLC: OHLCV = OHLCV.CLOSE,
        rightBarOHLC: OHLCV = OHLCV.CLOSE,

    ): Boolean

    fun isFalling(

        leftBarIndex: Int = barCount - 2,
        rightBarIndex: Int = barCount - 1,

        leftBarOHLC: OHLCV = OHLCV.CLOSE,
        rightBarOHLC: OHLCV = OHLCV.CLOSE,

    ): Boolean

    fun isOver(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = 0,
        barIndex: Int = 1,

        comparableOHLC: OHLCV = OHLCV.CLOSE,
        barOHLC: OHLCV = OHLCV.CLOSE,

        period: Int = 0

    ): Boolean

    fun isUnder(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = 0,
        barIndex: Int = 1,

        comparableOHLC: OHLCV = OHLCV.CLOSE,
        barOHLC: OHLCV = OHLCV.CLOSE,

        period: Int = 0

    ): Boolean

    fun crossOver(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = barCount - 13,
        barIndex: Int = barCount - 1,

        comparableOHLC: OHLCV = OHLCV.CLOSE,
        barOHLC: OHLCV = OHLCV.CLOSE,

        ): Boolean


    fun crossUnder(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = 0,
        barIndex: Int = 1,

        comparableOHLC: OHLCV = OHLCV.CLOSE,
        barOHLC: OHLCV = OHLCV.CLOSE,

        period: Int = 0

    ): Boolean


    fun pivotUp(

        period: Int = 0,

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,

        leftBarOHLC: OHLCV = OHLCV.CLOSE,
        rightBarOHLC: OHLCV = OHLCV.CLOSE

    ): Boolean


    fun pivotDown(

        period: Int = 0,

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,

        leftBarOHLC: OHLCV = OHLCV.CLOSE,
        rightBarOHLC: OHLCV = OHLCV.CLOSE

    ): Boolean

//
//    fun bullishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBullishDivergence(indicator: T): ConditionAlertSupplier
//
//    fun bearishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBearishDivergence(indicator: T): ConditionAlertSupplier
}