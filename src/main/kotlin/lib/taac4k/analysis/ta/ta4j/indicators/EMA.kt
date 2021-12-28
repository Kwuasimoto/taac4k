package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.EMAConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.indicators.EMAIndicator

open class EMA(
    open val close: Close,
    open val barCount: Int = 12,

    override val adapter: BaseMarketDataAdapter = MarketDataAdapter(),
    override val conditions: EMAConditions = EMAConditions(close.marketDataList),
    override val rawIndicator: EMAIndicator = EMAIndicator(close.rawIndicator, barCount)

) : IndicatorConditions<EMAConditions>