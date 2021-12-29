package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.conditions.cache.BaseConditionsCache
import lib.taac4k.analysis.ta.conditions.cache.ConditionsCache
import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

open class BaseValueConditions(
    override val marketDataMutableList: MutableList<MarketData>,
    override val values: MarketDataValuesProvider
) : ValueConditions {

    protected val cache: ConditionsCache = BaseConditionsCache()

    override fun isRising(leftBarIndex: Int, rightBarIndex: Int, leftBarOHLCV: OHLCV, rightBarOHLCV: OHLCV): Boolean {
        val barGapLength = rightBarIndex - leftBarIndex

        if (barGapLength == 0)
            throw IllegalArgumentException("Cannot check if a single bar is rising, maybe in the future on live charts :)")

        return if (barGapLength >= 2) {
            for (i in 0 until barGapLength) {
                if (!cache.boolCache) break
                if (leftBarIndex >= rightBarIndex) break

                val trueLeftIndex = leftBarIndex + (i)
                val trueRightIndex = rightBarIndex - (barGapLength - (i + 1))

                val leftVal = values.barValue(trueLeftIndex, leftBarOHLCV)
                val rightVal = values.barValue(trueRightIndex, rightBarOHLCV)

                cache.boolCache = rightVal > leftVal
            }

            cache.reset()
        } else values.barValue(rightBarIndex, rightBarOHLCV) > values.barValue(leftBarIndex, leftBarOHLCV)
    }

    override fun isFalling(leftBarIndex: Int, rightBarIndex: Int, leftBarOHLCV: OHLCV, rightBarOHLCV: OHLCV): Boolean =
        !isRising(leftBarIndex, rightBarIndex, leftBarOHLCV, rightBarOHLCV)

    override fun crossOver(
        target: Double,
        barsBack: Int,
        ohlcv: OHLCV

    ): Boolean {
        if (barsBack <= 0) throw IllegalArgumentException("barsBack must be greater than 0")
        if (values.barValue(values.barCount - 1 - barsBack) > target) return false

        for (i in 0 until barsBack + 1)
            if (cache.boolCache) break
            else cache.boolCache = values.barValue((values.barCount - 1) - (barsBack - i), ohlcv) > target

        return cache.reset()
    }

    override fun crossUnder(target: Double, barsBack: Int, ohlcv: OHLCV): Boolean {
        if (barsBack <= 0) throw IllegalArgumentException("barsBack must be greater than 0")
        if (values.barValue(values.barCount - 1 - barsBack) > target) return false

        for (i in 0 until barsBack + 1)
            if (cache.boolCache) break
            else cache.boolCache = values.barValue((values.barCount - 1) - (barsBack - i), ohlcv) < target

        return cache.reset()
    }

    override fun percentChanged(
        change: Float,
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean = true
}