package lib.ta4j.indicators.conditions.suppliers

import lib.ta4j.indicators.alerts.suppliers.ZonedAlert

interface IndicatorConditionSupplier<Indicator, ConditionProvider> {
    val conditions: ConditionProvider
    fun checkCondition(condition: (it: Indicator) -> ZonedAlert): ZonedAlert
}