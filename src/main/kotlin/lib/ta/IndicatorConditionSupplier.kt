package lib.ta

import lib.ta.alerts.ZonedAlert
import java.util.function.BooleanSupplier

/**
 * Implement onto CustomIndicator Classes [@Indicators]
 */
interface IndicatorConditionSupplier<Indicator, ConditionsType> {
    val conditions: ConditionsType
    fun checkCondition(condition: (it: Indicator) -> Boolean): BooleanSupplier
}