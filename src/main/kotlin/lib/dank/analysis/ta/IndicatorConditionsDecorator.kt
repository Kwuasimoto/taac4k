package lib.dank.analysis.ta

import lib.dank.analysis.ta.conditions.executor.IndicatorConditionsExecutor
import lib.dank.markets.data.adapter.MarketDataAdapter

interface IndicatorConditionsDecorator<IndicatorType, ConditionsType> :
    IndicatorConditionsExecutor {
    val adapter: MarketDataAdapter
    val rawIndicator: IndicatorType
    val conditions: ConditionsType
}