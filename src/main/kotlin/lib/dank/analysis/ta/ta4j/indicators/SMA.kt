package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditionsDecorator
import lib.dank.analysis.ta.conditions.SMAConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.SMAIndicator

class SMA(
    close: Close,
    length: Int = 13,

    override val adapter: MarketDataAdapter,
    override val rawIndicator: SMAIndicator = SMAIndicator(close.rawIndicator , length),
    override val conditions: SMAConditions = SMAConditions(close.MarketDataList)

) : IndicatorConditionsDecorator<SMAIndicator, SMAConditions>