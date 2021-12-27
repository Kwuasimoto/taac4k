package lib.dank.analysis.ta.conditions.executor

import java.util.function.BooleanSupplier

/**
 * for checking the conditions' property functions on the Indicator objects,
 */
@FunctionalInterface
interface IndicatorConditionsExecutor {
    fun checkCondition(condition: () -> Boolean): BooleanSupplier = BooleanSupplier { condition ( ) }
}