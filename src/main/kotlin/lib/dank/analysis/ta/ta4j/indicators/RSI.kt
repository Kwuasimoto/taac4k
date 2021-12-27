package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditionsDecorator
import lib.dank.analysis.ta.conditions.RSIConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.RSIIndicator

open class RSI(
    close: Close,
    barCount: Int = 12,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val rawIndicator: RSIIndicator = RSIIndicator(close.rawIndicator, barCount),
    override val conditions: RSIConditions = RSIConditions(close.MarketDataList)

) : IndicatorConditionsDecorator<RSIIndicator, RSIConditions>