package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

/**
 * ### Default Condition Supplier
 */

interface ConditionsProvider {
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

        comparableIndex: Int = comparableList.size - 1,
        index: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE,

        period: Int = 0

    ): Boolean

    fun isUnder(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = comparableList.size - 1,
        index: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE,

        period: Int = 0

    ): Boolean

    fun crossOver(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = comparableList.size - 1,
        index: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossOver(
        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE,
    ): Boolean


    fun crossUnder(

        rightBarIndex: Int = 0,
        leftBarIndex: Int = 0,

        rightBarOHLCV: OHLCV = OHLCV.CLOSE,
        leftBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossUnder(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int = 0,
        index: Int = 0,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

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