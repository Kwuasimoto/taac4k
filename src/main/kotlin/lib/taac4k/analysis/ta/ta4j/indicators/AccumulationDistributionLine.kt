package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.analysis.ta.conditions.ADLineConditions
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.RecursiveCachedIndicator
import org.ta4j.core.indicators.volume.AccumulationDistributionIndicator

open class AccumulationDistributionLine(
    open val marketDataList: MutableList<MarketData>,

    override val adapter: MarketDataAdapter,
    override val rawIndicator: AccumulationDistributionIndicator = AccumulationDistributionIndicator(adapter.toBarSeries(marketDataList)),
    override val conditions: ADLineConditions = ADLineConditions(marketDataList)

) : IndicatorConditions<ADLineConditions>