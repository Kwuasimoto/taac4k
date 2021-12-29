package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.BaseSentimentConditions
import lib.taac4k.analysis.ta.conditions.SentimentConditions
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.volume.AccumulationDistributionIndicator

open class AccumulationDistributionLine(
    open val marketDataList: MutableList<MarketData>,

    override val adapter: MarketDataAdapter,
    override val values: MarketDataValuesProvider = MarketDataValues(marketDataList),

    override val rawIndicator: AccumulationDistributionIndicator = AccumulationDistributionIndicator(
        adapter.toBarSeries(
            marketDataList
        )
    ),
    override val conditions: SentimentConditions = BaseSentimentConditions(
        marketDataList, values, 30, 70, 50)

) : ConditionalIndicator