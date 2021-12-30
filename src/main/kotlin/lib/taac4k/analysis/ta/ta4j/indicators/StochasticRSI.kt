package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.BaseSentimentConditions
import lib.taac4k.analysis.ta.conditions.SentimentConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.StochasticRSIIndicator

class StochasticRSI(
    val close: Close,
    val stochLength: Int = 13,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),
    override val rawIndicator: StochasticRSIIndicator = StochasticRSIIndicator(close.rawIndicator, stochLength),
    override val conditions: SentimentConditions = BaseSentimentConditions(close.marketDataList, values, 20, 80, 50)

) : ConditionalIndicator