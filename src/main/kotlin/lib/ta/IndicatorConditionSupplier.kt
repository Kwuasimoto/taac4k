package lib.ta

import lib.ta.alerts.ZonedAlert

/**
 * Implement onto CustomIndicator Classes [@Indicators]
 */
interface IndicatorConditionSupplier<Indicator, ConditionProvider> {
    val conditions: ConditionProvider
    fun checkCondition(condition: (it: Indicator) -> ZonedAlert): ZonedAlert
}