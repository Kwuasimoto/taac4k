package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.ADLineConditions
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.indicators.volume.AccumulationDistributionIndicator

open class AccumulationDistributionLine(
    open val marketDataList: MutableList<MarketData>,

    override val adapter: BaseMarketDataAdapter,
    override val rawIndicator: AccumulationDistributionIndicator = AccumulationDistributionIndicator(adapter.toBarSeries(marketDataList)),
    override val conditions: ADLineConditions = ADLineConditions(marketDataList),
    override val values: MarketDataValuesProvider = MarketDataValuesProvider(marketDataList)

) : IndicatorConditions<ADLineConditions>