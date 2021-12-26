package lib.dank.analysis.ta

import lib.dank.analysis.ta.enums.OHLC
import lib.dank.markets.data.JSONMarketData

/**
 * To implement a diff TA Lib you'd have to switch out their *Indicator*
 * interface here and re-implement the default methods,
 */
abstract class IndicatorConditions(override val marketDataList: MutableList<JSONMarketData>) : IndicatorConditionsProvider {

    override val barCount: Int = marketDataList.size




    /**
     * Period not integrated, will be today :)
     */
    override fun percentChanged(

        change: Float,

        leftBarIndex: Int,
        rightBarIndex: Int,

        period: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = alert {
        period != 0
    }

    /**
     * This Indicator isRising?
     */
    override fun isRising(

        leftBarIndex: Int,
        rightBarIndex: Int,

        period: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = alert {
        if (period > 0) {
            var result = true

            for (i in 0 until period) {
                if (!result) break
                if (i == 0) continue

                result = barValue(barCount - (i + 1) - leftBarIndex, leftBarOHLC) <
                         barValue(barCount - i - rightBarIndex, rightBarOHLC)
            }

            result
        } else barValue(barCount - 2, leftBarOHLC) < barValue(barCount - 1, rightBarOHLC)
    }

    /**
     * @param indicator barSeries isFalling
     * @param period barSeries isFalling for period
     */
    override fun isFalling(

        leftBarIndex: Int,
        rightBarIndex: Int,

        period: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = alert {
        !this.isRising(period)
    }

    override fun isOver(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int,
        targetIndex: Int,

        period: Int,

        barOHLC: OHLC,
        targetOHLC: OHLC

    ): Boolean = alert {
        if (barIndex == 0 && targetIndex == 0){

        }
        if (barIndex == 0) {
            // Is this closePrice greater than target price
            barValue(barCount - 1, barOHLC) >
            barValue(targetSeries, barCount - 2, targetOHLC)
        }
        if (targetIndex == 0) {
            // Is this closePrice greater than target price
            barValue(barIndex, barOHLC) >
            barValue(targetSeries, barIndex-1, targetOHLC)
        } else {
            barValue(barIndex, barOHLC) >
            barValue(targetSeries, targetIndex, targetOHLC)
        }
    }

    override fun isUnder(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int,
        targetIndex: Int,

        period: Int,

        barOHLC: OHLC,
        targetOHLC: OHLC

    ): Boolean = alert {
        !this.isOver(targetSeries, barIndex, targetIndex, period, barOHLC, targetOHLC)
    }

    /**
     * Situations:
     *
     */
    override fun crossOver(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int,
        targetIndex: Int,

        period: Int,

        barOHLC: OHLC,
        targetOHLC: OHLC

    ): Boolean = alert {
//        val targetToCross = barSeries.getBar(barIndex).closePrice
//
//        /**
//         * Check if left bar is under target, and right bar is over,
//         */
//
//        if (barIndex == 0) {
//            close(barCount - 1) > targetToCross &&
//                    close(barCount - 2) <= targetToCross
//        } else {
//            close(barIndex) > targetToCross &&
//                    close(barIndex - 1) <= targetToCross
//        }
        TODO("")
    }

    override fun crossUnder(

        targetSeries: MutableList<JSONMarketData>,

        barIndex: Int,
        targetIndex: Int,

        period: Int,

        barOHLC: OHLC,
        targetOHLC: OHLC

    ): Boolean = alert {
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

    ): Boolean = alert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(

        period: Int,

        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLC: OHLC,
        rightBarOHLC: OHLC

    ): Boolean = alert {
        TODO("Not yet implemented")
    }
}

