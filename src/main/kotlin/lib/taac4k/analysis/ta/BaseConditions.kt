package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.enums.OHLC
import lib.taac4k.markets.data.MarketData

/**
 * To implement a diff TA Lib you'd have to switch out their *Indicator*
 * interface here and re-implement the default methods,
 */
abstract class BaseConditions(
    open val marketDataMutableList: MutableList<MarketData>,
) : ConditionsProvider {

//    override val barCount: Int = marketDataList.size
    private var cachedBool: Boolean = false
    private var cachedBarsLeft: Int = 0

    /**
     * Period not integrated, will be today :)
     */
    override fun percentChanged(

        change: Float,

        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = check { true }

    /**
     * This Indicator isRising?
     * Define a leftBarIndex, and scan to rightBarIndex || barCount -1 (rightBarIndex default)
     * Checks to make sure every bar is rising sequentially
     *
     * @TODO Add a grace period that allows the price to drop/rise for x bars before rising/falling again
     */
    override fun isRising(

        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = check {
        val barGapLength = rightBarIndex - leftBarIndex

        if (barGapLength > 1) {
            var result = true

            for (i in 0 until barGapLength) {
                if (!result) break
                if (leftBarIndex >= rightBarIndex) break

                val trueLeftIndex = leftBarIndex + (i)
                val trueRightIndex = rightBarIndex - (barGapLength - (i + 1))

                val leftVal = values.barValue(trueLeftIndex, leftBarOHLC)
                val rightVal = values.barValue(trueRightIndex, rightBarOHLC)

                result = rightVal > leftVal
            }

            result
        } else values.barValue(rightBarIndex, rightBarOHLC) > values.barValue(leftBarIndex, leftBarOHLC)

    }

    /**
     */
    override fun isFalling(

        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = check {
        !isRising(leftBarIndex, rightBarIndex, leftBarOHLC, rightBarOHLC)
    }

    override fun isOver(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int,
        barIndex: Int,

        comparableOHLC: OHLC,
        barOHLC: OHLC,

        period: Int

    ): Boolean = check {
        if(comparableIndex < 0 || barIndex < 0 ) throw IllegalArgumentException("comparableIndex or barIndex cannot be 0!")

        if (comparableIndex == 0 && barIndex == 0)
            throw IllegalArgumentException("barIndex and targetIndex cannot be 0")

        // Is this closePrice greater than target price
        if (comparableIndex == 0)
            values.barValue(barIndex, barOHLC) >
                    values.barValue(comparableList, barIndex, comparableOHLC)

        if (barIndex == 0)
            values.barValue(comparableIndex, comparableOHLC) >
                    values.barValue(comparableList, comparableIndex - 1, barOHLC)
        else {
            val barVal = values.barValue(barIndex, barOHLC)
            val comparableVal = values.barValue(comparableList, comparableIndex, comparableOHLC)

            barVal > comparableVal
        }
    }

    override fun isUnder(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int,
        barIndex: Int,

        comparableOHLC: OHLC,
        barOHLC: OHLC,

        period: Int


    ): Boolean = check {
        !isOver(comparableList, comparableIndex, barIndex, comparableOHLC, barOHLC, period)
    }

    /**
     *
     * Starts at comparableIndex,
     */
    override fun crossOver(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int,
        barIndex: Int,

        comparableOHLC: OHLC,
        barOHLC: OHLC

    ): Boolean {
        val barGap = barIndex - comparableIndex

        val resultBool = check {
            if (cachedBool) cachedBool
            if (comparableIndex < barIndex) throw IllegalArgumentException("Bar Index [Right bar] must be greater than Target Index [Left Bar]")

            if (barGap > 1) {

                for (i in 0 until barGap) {
                    if (cachedBool) break

                }

                if (values.barValue(barIndex, barOHLC) > values.barValue(comparableList, comparableIndex, comparableOHLC)) {
                    TODO("")

                }
                TODO("")

            } else {
                cachedBool = values.barValue(barIndex, barOHLC) > values.barValue(comparableList, comparableIndex, comparableOHLC)

                crossOver(
                    comparableList,
                    barIndex,
                    comparableIndex,
                    comparableOHLC,
                    barOHLC
                )
            }
        }
        cachedBool = false
        return resultBool
    }

    override fun crossUnder(

        comparableList: MutableList<MarketData>,

        comparableIndex: Int,
        barIndex: Int,

        comparableOHLC: OHLC,
        barOHLC: OHLC,

    ): Boolean = check {
//        val targetToCross = barSeries.getBar(barIndex).closePrice
//
//        /**
//         * Check if left bar is under target, and right bar is over,
//         */
//
//        if (barIndex == 0) {
//            close(barCount - 1) < targetToCross &&
//                    close(barCount - 2) >= targetToCross
//        } else {
//            close(barIndex) < targetToCross &&
//                    close(barIndex - 1) >= targetToCross
//        }
        TODO("")
    }

    override fun pivotUp(

        period: Int,

        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = check {
        TODO("Not yet implemented")
    }

    override fun pivotDown(

        period: Int,

        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = check {
        TODO("Not yet implemented")
    }
}

