package lib.dank.analysis.ta.ta4j.indicators.decorators

import lib.dank.analysis.ta.MarketAnalysisAdapter
import java.util.function.BooleanSupplier

interface WithConditions {
    val adapter: MarketAnalysisAdapter
    fun checkCondition(condition: () -> Boolean): BooleanSupplier = BooleanSupplier { condition ( ) }
}