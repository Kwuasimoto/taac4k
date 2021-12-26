package lib.dank.analysis.ta.conditions.executor

import lib.dank.analysis.ta.alerts.ZonedAlert

interface ZonedConditionsExecutor : ConditionsExecutor {
    fun checkConditionZoned(condition: () -> Boolean): ZonedAlert = ZonedAlert(condition())
}