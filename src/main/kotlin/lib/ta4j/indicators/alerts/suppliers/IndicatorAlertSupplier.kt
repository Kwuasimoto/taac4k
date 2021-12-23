package lib.ta4j.indicators.alerts.suppliers

import lib.ta4j.indicators.alerts.ZonedAlertSupplier

interface IndicatorAlertSupplier {
    fun alert(bool: () -> Boolean): ZonedAlertSupplier = ZonedAlertSupplier(bool())
}
