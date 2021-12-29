package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.EMAConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.EMAIndicator

open class EMA(
    open val close: Close,
    open val barCount: Int = 12,

    override val adapter: BaseMarketDataAdapter = MarketDataAdapter(),
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),

    override val rawIndicator: EMAIndicator = EMAIndicator(close.rawIndicator, barCount),
    override val conditions: EMAConditions = EMAConditions(close.marketDataList, values)

    ) : IndicatorConditions<EMAConditions>