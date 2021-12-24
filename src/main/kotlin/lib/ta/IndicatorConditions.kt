package lib.ta

import lib.ta.ta4j.suppliers.IndicatorBarValueProvider
import org.ta4j.core.BarSeries
import org.ta4j.core.Indicator

/**
 * To implement a diff TA Lib you'd have to switch out their *Indicator*
 * interface here and re-implement the default methods,
 */
abstract class IndicatorConditions(indicator: Indicator<*>):
    IndicatorBarValueProvider(indicator), IndicatorConditionsProvider {

    /**
     * Period not integrated, will be today :)
     */
    override fun percentChanged(change: Float, barIndex: Int, period: Int): Boolean = alert {
        period != 0
    }

    /**
     * This Indicator isRising?
     */
    override fun isRising(period: Int): Boolean = alert {
        if(period > 0) {
            var result = true

            for (i in 0 until period) {
                if(!result) break
                if(i == 0) continue;

                result = close(barCount - i) >
                         close(barCount - (i + 1))
            }

            result
        }
        else close(barCount - 1) >
             close(barCount - 2)
    }

    /**
     * @param indicator barSeries isFalling
     * @param period barSeries isFalling for period
     */
    override fun isFalling(period: Int): Boolean = alert {
        !this.isRising(period)
    }

    override fun isOver(barSeries: BarSeries, barIndex: Int, period: Int): Boolean = alert {
        if(barIndex == 0){
            // Is this closePrice greater than target price
            close(barSeries.barCount - 1) >
            barSeries.getBar(barSeries.barCount - 1).closePrice
        } else {
            // Is this closePrice greater than target price
            close(barIndex) >
            barSeries.getBar(barIndex).closePrice
        }
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int, period: Int): Boolean = alert {
        !this.isOver(barSeries, barIndex, period)
    }

    /**
     * Situations:
     *
     */
    override fun crossOver(barSeries: BarSeries, barIndex: Int, period: Int): Boolean = alert {
        val targetToCross = barSeries.getBar(barIndex).closePrice

        /**
         * Check if left bar is under target, and right bar is over,
         */

        if(barIndex == 0){
            close(barCount - 1) > targetToCross &&
            close(barCount - 2) <= targetToCross
        } else {
            close(barIndex) > targetToCross &&
            close(barIndex - 1) <= targetToCross
        }
    }

    override fun crossUnder(barSeries: BarSeries, barIndex: Int, period: Int): Boolean = alert {
        val targetToCross = barSeries.getBar(barIndex).closePrice

        /**
         * Check if left bar is under target, and right bar is over,
         */

        if(barIndex == 0){
            close(barCount - 1) < targetToCross &&
            close(barCount - 2) >= targetToCross
        } else {
            close(barIndex) < targetToCross &&
            close(barIndex - 1) >= targetToCross
        }
    }

    override fun pivotUp(leftBarIndex: Int, rightBarIndex: Int): Boolean = alert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(leftBarIndex: Int, rightBarIndex: Int): Boolean = alert {
        TODO("Not yet implemented")
    }
}