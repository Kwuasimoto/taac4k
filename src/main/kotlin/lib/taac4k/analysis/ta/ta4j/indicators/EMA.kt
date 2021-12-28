package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.analysis.ta.conditions.EMAConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.EMAIndicator

open class EMA(
    open val close: Close,
    open val barCount: Int = 12,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val conditions: EMAConditions = EMAConditions(close.marketDataList),
    override val rawIndicator: EMAIndicator = EMAIndicator(close.rawIndicator, barCount)

) : IndicatorConditions<EMAIndicator, EMAConditions>