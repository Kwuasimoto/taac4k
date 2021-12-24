package lib.ta.ta4j.decorator

import java.util.function.BooleanSupplier

open class BaseIndicator<IndicatorType> {
    fun checkCondition(condition: () -> Boolean): BooleanSupplier = BooleanSupplier { condition ( ) }
}