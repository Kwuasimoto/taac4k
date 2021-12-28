package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.analysis.ta.conditions.ADXConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.adx.ADXIndicator

open class ADX(
    open val close: Close,

    open val length: Int = 13,
    open val smoothing: Int = 7,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val rawIndicator: ADXIndicator = ADXIndicator(adapter.toBarSeries(close.marketDataList), length, smoothing),
    override val conditions: ADXConditions = ADXConditions(close.marketDataList)

) : IndicatorConditions<ADXConditions>