package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.BaseSentimentConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.RSIIndicator

open class RSI(
    open val close: Close,
    open val barCount: Int = 12,

    override val adapter: MarketDataAdapter = close.adapter,
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),

    override val rawIndicator: RSIIndicator = RSIIndicator(close.rawIndicator, barCount),
    override val conditions: BaseSentimentConditions = BaseSentimentConditions(
        close.marketDataList,
        values, 28, 72, 49
    )

) : ConditionalIndicator