package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.conditions.executor.IndicatorConditionsExecutor
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num

interface IndicatorConditions<ConditionsType> : IndicatorConditionsExecutor {

    // Convenience Properties
    val adapter: BaseMarketDataAdapter
    val values: MarketDataValuesProvider

    // Change out TA4J Here
    val rawIndicator: Indicator<Num>

    // Conditions related to [this.rawIndicator]
    val conditions: ConditionsType
}