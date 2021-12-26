package lib.dank.analysis.ta

import lib.dank.analysis.ta.enums.OHLC
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.suppliers.MarketDataValueSupplier

/**
 * ### Default Condition Supplier
 */

interface IndicatorConditionsProvider : MarketDataValueSupplier, ConditionAlertSupplier {
//    /**
//     *
//     */
//    fun barsSince condition: () -> ConditionAlertSupplier, length: Int): ConditionAlertSupplier

    fun percentChanged(

        change: Float,

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,

        period: Int = 0,

        leftBarOHLC: OHLC = OHLC.CLOSE,
        rightBarOHLC: OHLC = OHLC.CLOSE

    ): Boolean

    fun isRising(

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,

        period: Int = 0,

        leftBarOHLC: OHLC = OHLC.CLOSE,
        rightBarOHLC: OHLC = OHLC.CLOSE

    ): Boolean

    fun isFalling(

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,

        period: Int = 0,

        leftBarOHLC: OHLC = OHLC.CLOSE,
        rightBarOHLC: OHLC = OHLC.CLOSE

    ): Boolean

    fun isOver(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int = 0,
        targetIndex: Int = 1,

        period: Int = 0,

        barOHLC: OHLC = OHLC.CLOSE,
        targetOHLC: OHLC = OHLC.CLOSE

    ): Boolean

    fun isUnder(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int = 0,
        targetIndex: Int = 1,

        period: Int = 0,

        barOHLC: OHLC = OHLC.CLOSE,
        targetOHLC: OHLC = OHLC.CLOSE

    ): Boolean

    fun crossOver(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int = 0,
        targetIndex: Int = 1,

        period: Int = 0,

        barOHLC: OHLC = OHLC.CLOSE,
        targetOHLC: OHLC = OHLC.CLOSE

    ): Boolean


    fun crossUnder(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int = 0,
        targetIndex: Int = 1,

        period: Int = 0,

        barOHLC: OHLC = OHLC.CLOSE,
        targetOHLC: OHLC = OHLC.CLOSE

    ): Boolean


    fun pivotUp(

        period: Int = 0,

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,


        leftBarOHLC: OHLC = OHLC.CLOSE,
        rightBarOHLC: OHLC = OHLC.CLOSE

    ): Boolean


    fun pivotDown(

        period: Int = 0,

        leftBarIndex: Int = 0,
        rightBarIndex: Int = 1,

        leftBarOHLC: OHLC = OHLC.CLOSE,
        rightBarOHLC: OHLC = OHLC.CLOSE

    ): Boolean

//
//    fun bullishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBullishDivergence(indicator: T): ConditionAlertSupplier
//
//    fun bearishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBearishDivergence(indicator: T): ConditionAlertSupplier
}