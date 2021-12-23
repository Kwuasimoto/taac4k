package lib.ta

import org.ta4j.core.BarSeries
import org.ta4j.core.Indicator

/**
 * To implement a diff TA Lib you'd have to switch out their *Indicator*
 * interface here and re-implement the default methods,
 */
abstract class IndicatorConditions(
    private val indicator: Indicator<*>

    ): IndicatorConditionsProvider {

    /**
     * Period not integrated, will be today :)
     */
    override fun percentChanged(change: Float, barIndex: Int, period: Int): Boolean = alert {
        if(period == 0) {
            val open = indicator.barSeries.getBar(barIndex).openPrice
            val close = indicator.barSeries.getBar(barIndex).closePrice
            //val actualChange =

            false
        } else true
    }

    /**
     * This Indicator isRising?
     */
    override fun isRising(numOfBars: Int): Boolean = alert {
        if(numOfBars > 0) {
            var result = true

            for (i in 0 until numOfBars) {
                if(!result) break
                if(i == 0) continue;

                result = indicator.barSeries.getBar(indicator.barSeries.barCount - i).closePrice >
                        indicator.barSeries.getBar(indicator.barSeries.barCount - (i + 1)).closePrice
            }

            result
        }
        else indicator.barSeries.getBar(indicator.barSeries.barCount - 1).closePrice >
                indicator.barSeries.getBar(indicator.barSeries.barCount - 2).closePrice
    }

    /**
     * @param indicator barSeries isFalling
     * @param numOfBars barSeries isFalling for period
     */
    override fun isFalling(numOfBars: Int): Boolean = alert {
        !this.isRising(numOfBars)
    }

    override fun isOver(barSeries: BarSeries, barIndex: Int, length: Int): Boolean = alert {
        val targetPrice = barSeries.getBar(barIndex).closePrice

        if(barIndex == 0){
            indicator.barSeries.getBar(barIndex).closePrice > targetPrice
        } else {
            indicator.barSeries.getBar(indicator.barSeries.barCount - 1).closePrice > targetPrice
        }
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int, length: Int): Boolean = alert {
        !this.isOver(barSeries, barIndex, length)
    }

    /**
     * @param indicator
     * period - [not integrated yet]
     */
    override fun crossOver(barSeries: BarSeries, barIndex: Int, period: Int): Boolean = alert {
        val targetToCross = barSeries.getBar(barIndex).closePrice

        /**
         * Check if left bar is under target, and right bar is over,
         */

        if(barIndex == 0){
            indicator.barSeries.getBar(barIndex).closePrice > targetToCross &&
            indicator.barSeries.getBar(barIndex - 1).closePrice <= targetToCross
        } else {
            indicator.barSeries.getBar(indicator.barSeries.barCount - 1).closePrice > targetToCross &&
            indicator.barSeries.getBar(indicator.barSeries.barCount - 2).closePrice <= targetToCross
        }
    }

    override fun crossUnder(barSeries: BarSeries, barIndex: Int, length: Int): Boolean = alert {
        val targetToCross = barSeries.getBar(barIndex).closePrice

        /**
         * Check if left bar is under target, and right bar is over,
         */

        if(barIndex == 0){
            indicator.barSeries.getBar(barIndex).closePrice < targetToCross &&
            indicator.barSeries.getBar(barIndex - 1).closePrice >= targetToCross
        } else {
            indicator.barSeries.getBar(indicator.barSeries.barCount - 1).closePrice < targetToCross &&
            indicator.barSeries.getBar(indicator.barSeries.barCount - 2).closePrice >= targetToCross
        }
    }

    override fun pivotUp(checkFrom: Int, length: Int): Boolean = alert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(checkFrom: Int, length: Int): Boolean = alert {
        TODO("Not yet implemented")
    }
}