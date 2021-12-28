package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.analysis.ta.conditions.AroonConditions
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.AroonOscillatorIndicator

open class Aroon(
    open val close: Close,
    open val length: Int = 13,

    override val adapter: MarketDataAdapter,
    override val rawIndicator: AroonOscillatorIndicator = AroonOscillatorIndicator(adapter.toBarSeries(close.marketDataList), length),
    override val conditions: AroonConditions = AroonConditions(close.marketDataList)

) : IndicatorConditions<AroonConditions>