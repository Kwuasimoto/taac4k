package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.AroonConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.indicators.AroonOscillatorIndicator

open class Aroon(
    open val close: Close,
    open val length: Int = 13,

    override val adapter: BaseMarketDataAdapter = close.adapter,
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),

    override val rawIndicator: AroonOscillatorIndicator = AroonOscillatorIndicator(adapter.toBarSeries(close.marketDataList), length),
    override val conditions: AroonConditions = AroonConditions(close.marketDataList, values)

    ) : IndicatorConditions<AroonConditions>