package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.BaseSentimentConditions
import lib.taac4k.analysis.ta.conditions.SentimentConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.adx.ADXIndicator

open class ADX(
    open val close: Close,

    open val length: Int = 13,
    open val smoothing: Int = 7,

    override val adapter: MarketDataAdapter = close.adapter,
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),

    override val rawIndicator: ADXIndicator = ADXIndicator(
        adapter.toBarSeries(close.marketDataList),
        length,
        smoothing
    ),
    override val conditions: SentimentConditions = BaseSentimentConditions(
        close.marketDataList,
        values, overBought = 55, overSold = 55, threshold = 21
    )

) : ConditionalIndicator