package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.ADXConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.indicators.adx.ADXIndicator

open class ADX(
    open val close: Close,

    open val length: Int = 13,
    open val smoothing: Int = 7,

    override val adapter: BaseMarketDataAdapter = MarketDataAdapter(),
    override val rawIndicator: ADXIndicator = ADXIndicator(adapter.convert(close.marketDataList), length, smoothing),
    override val conditions: ADXConditions = ADXConditions(close.marketDataList)

) : IndicatorConditions<ADXConditions>