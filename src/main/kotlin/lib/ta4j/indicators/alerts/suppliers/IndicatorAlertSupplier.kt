package lib.ta4j.indicators.alerts.suppliers

interface IndicatorAlertSupplier {
    fun alert(bool: () -> Boolean): ZonedAlert = ZonedAlert(bool())
}
