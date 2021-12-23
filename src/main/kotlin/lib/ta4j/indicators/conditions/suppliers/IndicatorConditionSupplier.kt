package lib.ta4j.indicators.conditions.suppliers

import lib.ta4j.indicators.alerts.ZonedAlertSupplier

interface IndicatorConditionSupplier<This, ConditionProvider> {
    val conditions: ConditionProvider
    fun checkCondition(condition: (it: This) -> ZonedAlertSupplier): ZonedAlertSupplier
}