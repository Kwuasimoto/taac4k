package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.analysis.ta.conditions.RSIConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.RSIIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator

open class RSI(
    open val close: Close,
    open val barCount: Int = 12,

    override val adapter: MarketDataAdapter = close.adapter,
    override val rawIndicator: RSIIndicator = RSIIndicator(close.rawIndicator, barCount),
    override val conditions: RSIConditions = RSIConditions(close.marketDataList)

) : IndicatorConditions<RSIConditions>