package lib.dank.analysis.ta

import lib.dank.analysis.ta.conditions.executor.IndicatorConditionsExecutor
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num

interface IndicatorConditions<ConditionsType> : IndicatorConditionsExecutor {
    val rawIndicator: Indicator<Num> /* #ta4j integration */
    val adapter: MarketDataAdapter
    val conditions: ConditionsType
}