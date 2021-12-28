package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.analysis.ta.conditions.SMAConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.SMAIndicator

open class SMA(
    open val close: Close,
    open val length: Int = 13,

    override val adapter: MarketDataAdapter = close.adapter,
    override val rawIndicator: SMAIndicator = SMAIndicator(close.rawIndicator , length),
    override val conditions: SMAConditions = SMAConditions(close.marketDataList)

) : IndicatorConditions<SMAConditions>