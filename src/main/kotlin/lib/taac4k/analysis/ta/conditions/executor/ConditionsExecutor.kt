package lib.dank.analysis.ta.conditions.executor

/**
 * for checking the conditions' executed within the Conditions objects,
 * supplies Results to [IndicatorConditionsExecutor]
 */
@FunctionalInterface
interface ConditionsExecutor {
    fun check(condition: () -> Boolean): Boolean = condition()
}
