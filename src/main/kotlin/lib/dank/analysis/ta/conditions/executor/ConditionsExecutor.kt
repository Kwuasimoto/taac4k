package lib.dank.analysis.ta.conditions.executor

import lib.dank.analysis.ta.MarketAnalysisAdapter
import java.util.function.BooleanSupplier

interface ConditionsExecutor {
    val adapter: MarketAnalysisAdapter
    fun checkCondition(condition: () -> Boolean): BooleanSupplier = BooleanSupplier { condition ( ) }
}