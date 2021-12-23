package lib.ta

import lib.ta.alerts.ZonedAlert
import lib.ta.ta4j.isRising
import org.ta4j.core.BarSeries
import org.ta4j.core.Indicator

/**
 * To implement a diff TA Lib you'd have to switch out their *Indicator*
 * interface here and re-implement the default methods,
 */
abstract class IndicatorConditions<T : Indicator<*>> : IndicatorConditionsProvider<T> {

    override fun isRising(indicator: T, length: Int): ZonedAlert = alert {
        indicator.barSeries.isRising(length)
    }

    override fun isFalling(indicator: T, length: Int): ZonedAlert = alert {
        !indicator.barSeries.isRising(length)
    }

    override fun crossOver(indicator: T, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isOver(indicator: T, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isUnder(indicator: T, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun crossUnder(indicator: T, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotUp(indicator: T, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(indicator: T, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }
}