package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV

/**
 * ## ValueConditions : ConditionsSupplier
 * Interface for abstracting *Value* specific conditions related to some target/change
 * and a value specified in *this* ConditionalIndicators marketDataList property.
 */
interface ValueConditions : ConditionsSupplier {
    /**
     * ## crossOver
     * @param target the target value to be crossed.
     * @param barsBack the amount of bars back to scan to the right most index.
     * @param ohlcv Check whether the open, high, low, close or vwap values crossed the target.
     * @return [Boolean]
     */
    fun crossOver(

        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## crossUnder
     * @param target the target value to be crossed.
     * @param barsBack the amount of bars back to scan to the right most index.
     * @param ohlcv Check whether the open, high, low, close or vwap values crossed the target.
     * @return [Boolean]
     */
    fun crossUnder(

        target: Double,

        barsBack: Int = 1,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## percentChanged (Not Implemented Yet)
     * @param change the amount changed over a period of time
     * @param leftBarIndex the index of the left bar to start at
     * @param rightBarIndex the index of the right bar to end at
     * @param leftBarOHLCV use the left bar OHLCV
     * @param rightBarOHLCV use the right bar OHLCV
     * @return [Boolean]
     */
    fun percentChanged(

        change: Float,

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## isRising
     * Scan from a left bar index to the right bar index and check if every bar's
     * ohlcv value is greater than the previous.
     * @param leftBarIndex the index of the left bar to start at
     * @param rightBarIndex the index of the right bar to end at
     * @param leftBarOHLCV use the left bar OHLCV
     * @param rightBarOHLCV use the right bar OHLCV
     * @return [Boolean]
     */
    fun isRising(

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## isFalling
     * Scan from a left bar index to the right bar index and check if every bar's
     * ohlcv value is less than the previous.
     * @param leftBarIndex the index of the left bar to start at
     * @param rightBarIndex the index of the right bar to end at
     * @param leftBarOHLCV use the left bar OHLCV
     * @param rightBarOHLCV use the right bar OHLCV
     * @return [Boolean]
     */
    fun isFalling(

        leftBarIndex: Int = values.barCount - 2,
        rightBarIndex: Int = values.barCount - 1,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE

    ): Boolean
}