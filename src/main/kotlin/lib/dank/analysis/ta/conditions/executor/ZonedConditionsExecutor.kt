package lib.dank.analysis.ta.conditions.executor

import lib.dank.analysis.ta.alerts.ZonedAlert

@FunctionalInterface
interface ZonedConditionsExecutor : IndicatorConditionsExecutor {
    fun checkConditionZoned(condition: () -> Boolean): ZonedAlert = ZonedAlert(condition())
}