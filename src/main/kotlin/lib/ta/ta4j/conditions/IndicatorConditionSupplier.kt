package lib.ta.ta4j.conditions

import lib.ta.ta4j.alerts.ZonedAlert

/**
 * Implement onto CustomIndicator Classes [@Indicators]
 */
interface IndicatorConditionSupplier<Indicator, ConditionProvider> {
    val conditions: ConditionProvider
    fun checkCondition(condition: (it: Indicator) -> ZonedAlert): ZonedAlert
}