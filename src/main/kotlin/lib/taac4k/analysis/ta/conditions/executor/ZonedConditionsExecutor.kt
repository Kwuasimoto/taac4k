package lib.taac4k.analysis.ta.conditions.executor

import lib.taac4k.analysis.ta.alerts.ZonedAlert

@FunctionalInterface
interface ZonedConditionsExecutor : ConditionsExecutor {
    fun checkZoned(condition: () -> Boolean): ZonedAlert = ZonedAlert(condition())
}