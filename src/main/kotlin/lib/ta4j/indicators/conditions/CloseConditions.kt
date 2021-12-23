package lib.ta4j.indicators.conditions

import lib.ta4j.indicators.Close
import lib.ta4j.indicators.alerts.CloseAlertSupplier
import lib.ta4j.indicators.conditions.providers.helpers.CloseConditionsProvider
import lib.ta4j.indicators.alerts.ZonedAlertSupplier
import org.ta4j.core.Bar

class CloseConditions : CloseConditionsProvider, CloseAlertSupplier {



    override fun movingUp(indicator: Close, length: Int): ZonedAlertSupplier =
        alert {
            indicator.barSeries.lastBar.closePrice >
            indicator.barSeries.getBar(indicator.barSeries.barCount-2).closePrice
        }

    override fun movingDown(indicator: Close, length: Int): ZonedAlertSupplier = alert {
        if(length > 0) {
            var result = true

            for (i in 0 until length) {
                if(!result) break
                if(i == 0) continue;

                val rightBar: Bar = indicator.barSeries.getBar(indicator.barSeries.barCount - i)
                val leftBar: Bar = indicator.barSeries.getBar(indicator.barSeries.barCount - (i + 1))

                result = rightBar.closePrice > leftBar.closePrice
            }

            result
        }

        else !this.movingUp(indicator).asBoolean
    }
}