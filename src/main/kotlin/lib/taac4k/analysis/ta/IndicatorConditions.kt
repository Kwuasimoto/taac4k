package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.conditions.executor.IndicatorConditionsExecutor
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num

interface IndicatorConditions<ConditionsType> : IndicatorConditionsExecutor {

    // Convenience Properties
    val values: MarketDataValuesProvider
    val adapter: BaseMarketDataAdapter

    // Change out TA4J Here
    val rawIndicator: Indicator<Num>

    // Required
    val conditions: ConditionsType
}