package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.conditions.executor.IndicatorConditionsExecutor
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num

interface IndicatorConditions<ConditionsType> : IndicatorConditionsExecutor {
    val rawIndicator: Indicator<Num> /* #ta4j integration */
    val adapter: MarketDataAdapter
    val conditions: ConditionsType
}