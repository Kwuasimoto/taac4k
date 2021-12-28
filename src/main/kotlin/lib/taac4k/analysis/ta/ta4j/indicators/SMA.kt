package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.SMAConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.indicators.SMAIndicator

open class SMA(
    open val close: Close,
    open val length: Int = 13,

    override val adapter: BaseMarketDataAdapter = close.adapter,
    override val rawIndicator: SMAIndicator = SMAIndicator(close.rawIndicator , length),
    override val conditions: SMAConditions = SMAConditions(close.marketDataList)

) : IndicatorConditions<SMAConditions>