package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.RSIConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.RSIIndicator

open class RSI(
    open val close: Close,
    open val barCount: Int = 12,

    override val adapter: MarketDataAdapter = close.adapter,
    override val rawIndicator: RSIIndicator = RSIIndicator(close.rawIndicator, barCount),
    override val conditions: RSIConditions = RSIConditions(close.marketDataList)

) : IndicatorConditions<RSIConditions>