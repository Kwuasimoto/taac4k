package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV

interface ComplexConditions : ValueConditions {

    fun pivotUp(

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean


    fun pivotDown(

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun bullishDivergence(
        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE
    ): Boolean

    fun bearishDivergence(
        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE
    ): Boolean

    fun hiddenBullishDivergence(): Boolean
    fun hiddenBearishDivergence(): Boolean

    fun isBullish(): Boolean
    fun isBearish(): Boolean
}