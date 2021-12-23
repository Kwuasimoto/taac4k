package lib.ta4j.indicators.conditions

import lib.ta4j.indicators.Close
import lib.ta4j.indicators.alerts.suppliers.CloseAlertSupplier
import lib.ta4j.indicators.conditions.providers.helpers.CloseConditionsProvider
import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import lib.ta4j.isRising
import org.ta4j.core.BarSeries

open class CloseConditions : CloseConditionsProvider, CloseAlertSupplier {

    override fun isRising(indicator: Close, length: Int): ZonedAlert = alert {
        indicator.barSeries.isRising(length)
    }

    override fun isFalling(indicator: Close, length: Int): ZonedAlert = alert {
        !indicator.barSeries.isRising(length)
    }

    override fun crossOver(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isOver(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isUnder(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun crossUnder(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotUp(indicator: Close, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(indicator: Close, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }
}


