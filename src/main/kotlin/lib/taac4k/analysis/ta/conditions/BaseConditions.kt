package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData

/**
 * To implement a diff TA Lib you'd have to switch out their *Indicator*
 * interface here and re-implement the default methods,
 */
abstract class BaseConditions(
    open val marketDataMutableList: MutableList<MarketData>
) : ValueConditions(), BaseConditionsProvider {
    // PSEUDO CACHE,
    // Didn't think itd be necessary for a class to handle these values.
    private var boolCache: Boolean = false
    private var barsLeftCache: Int = 0

    private fun resetCache(cachedBool: Boolean): Boolean {
        this.boolCache = false
        this.barsLeftCache = 0
        return cachedBool
    }

    /**
     * Period not integrated, will be today :)
     */
    override fun percentChanged(
        change: Float,
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean = true

    /**
     * This Indicator isRising?
     * Define a leftBarIndex, and scan to rightBarIndex || barCount -1 (rightBarIndex default)
     * Checks to make sure every bar is rising sequentially
     *
     * @TODO Add a grace period that allows the price to drop/rise for x bars before rising/falling again
     */
    override fun isRising(leftBarIndex: Int, rightBarIndex: Int, leftBarOHLCV: OHLCV, rightBarOHLCV: OHLCV): Boolean {
        val barGapLength = rightBarIndex - leftBarIndex

        if (barGapLength == 0)
            throw IllegalArgumentException("Cannot check if a single bar is rising, maybe in the future on live charts :)")

        return if (barGapLength >= 2) {
            for (i in 0 until barGapLength) {
                if (!boolCache) break
                if (leftBarIndex >= rightBarIndex) break

                val trueLeftIndex = leftBarIndex + (i)
                val trueRightIndex = rightBarIndex - (barGapLength - (i + 1))

                val leftVal = values.barValue(trueLeftIndex, leftBarOHLCV)
                val rightVal = values.barValue(trueRightIndex, rightBarOHLCV)

                boolCache = rightVal > leftVal
            }

             resetCache(boolCache)
        } else values.barValue(rightBarIndex, rightBarOHLCV) > values.barValue(leftBarIndex, leftBarOHLCV)
    }

    /**
     */
    override fun isFalling(leftBarIndex: Int, rightBarIndex: Int, leftBarOHLCV: OHLCV, rightBarOHLCV: OHLCV): Boolean =
        !isRising(leftBarIndex, rightBarIndex, leftBarOHLCV, rightBarOHLCV)

    override fun isOver(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV
    ): Boolean =
        if (comparableValueIndex < 0 || startValueIndex < 0) throw IllegalArgumentException("comparableIndex or barIndex cannot be less than 0!")
        else
            values.barValue(startValueIndex, ohlcv) >
            values.barValue(comparableList, comparableValueIndex, comparableOHLCV)


    override fun isUnder(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV
    ): Boolean =
        !isOver(comparableList, comparableValueIndex, startValueIndex, comparableOHLCV, ohlcv)

    override fun crossOver(
        target: Double,
        barsBack: Int,
        ohlcv: OHLCV

    ): Boolean {
        if (barsBack <= 0) throw IllegalArgumentException("barsBack must be greater than 0")
        if (values.barValue(values.barCount - 1 - barsBack) > target) return false

        for (i in 0 until barsBack + 1)
            if(boolCache) break
            else boolCache = values.barValue((values.barCount - 1) - (barsBack - i), ohlcv) > target

        return resetCache(boolCache)
    }
    /**
     *
     * Starts at comparableIndex,
     *
     * Check if barVal crosses over comparableVal at any point and returns true
     */
    override fun crossOver(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV,
    ): Boolean {
        // Check if value is above or below target on first iteration, return false if so,
        if (isOver(comparableList, comparableValueIndex, startValueIndex, comparableOHLCV, ohlcv))
            return boolCache

        for (i in 1 until marketDataMutableList.size)
            if (boolCache) break
            else if (isOver(comparableList, comparableValueIndex, startValueIndex + i, comparableOHLCV, ohlcv))
                boolCache = true


        return resetCache(boolCache)
    }
    override fun crossUnder(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV,

        ): Boolean {

        // Check if value is above or below target on first iteration, return false if so,
        if (isUnder(comparableList, comparableValueIndex, startValueIndex, comparableOHLCV, ohlcv))
            return boolCache

        for (i in 1 until marketDataMutableList.size)
            if (boolCache) break
            else if (isUnder(comparableList, comparableValueIndex, startValueIndex + i, comparableOHLCV, ohlcv))
                boolCache = true

        return resetCache(boolCache)
    }

    override fun crossUnder(target: Double, barsBack: Int, ohlcv: OHLCV): Boolean {
        if (barsBack <= 0) throw IllegalArgumentException("barsBack must be greater than 0")
        if (values.barValue(values.barCount - 1 - barsBack) > target) return false

        for (i in 0 until barsBack + 1)
            if(boolCache) break
            else boolCache = values.barValue((values.barCount - 1) - (barsBack - i), ohlcv) < target

        return resetCache(boolCache)
    }

    override fun pivotUp(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun pivotDown(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean {
        TODO("Not yet implemented")
    }
}

