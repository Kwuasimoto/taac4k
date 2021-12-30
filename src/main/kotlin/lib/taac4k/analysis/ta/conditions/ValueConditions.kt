package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV

interface ValueConditions : ConditionsSupplier {
    fun crossOver(
        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE
    ): Boolean

    fun crossUnder(

        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

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
}