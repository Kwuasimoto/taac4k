package lib.taac4k.analysis.ta.conditions.executor

import java.util.function.BooleanSupplier

/**
 * for checking the functions of the conditions' property an IndicatorConditions object
 */
@FunctionalInterface
interface IndicatorConditionsExecutor {
    fun check(condition: () -> Boolean): BooleanSupplier = BooleanSupplier { condition ( ) }
}