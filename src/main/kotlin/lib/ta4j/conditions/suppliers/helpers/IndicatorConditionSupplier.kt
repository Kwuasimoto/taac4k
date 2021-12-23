package lib.ta4j.conditions.suppliers.helpers

import lib.ta4j.alerts.ZonedAlert

/**
 * Implement onto CustomIndicator Classes [@Indicators]
 */
interface IndicatorConditionSupplier<Indicator, ConditionProvider> {
    val conditions: ConditionProvider
    fun checkCondition(condition: (it: Indicator) -> ZonedAlert): ZonedAlert
}