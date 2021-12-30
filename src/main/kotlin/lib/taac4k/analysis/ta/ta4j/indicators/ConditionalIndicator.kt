package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.ValueConditions
import lib.taac4k.analysis.ta.conditions.executor.ConditionsExecutor
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num

interface ConditionalIndicator : ConditionsExecutor {

    // Convenience Properties
    val adapter: MarketDataAdapter
    val values: MarketDataValuesProvider

    // Change out TA4J Here
    val rawIndicator: Indicator<Num>

    // Conditions related to [this.rawIndicator]
    val conditions: ValueConditions
}