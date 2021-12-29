package lib.taac4k.analysis.ta.ta4j.indicators.helpers

import lib.taac4k.analysis.ta.conditions.BasePositionalConditions
import lib.taac4k.analysis.ta.conditions.PositionalConditions
import lib.taac4k.analysis.ta.ta4j.indicators.ConditionalIndicator
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.helpers.VolumeIndicator

open class Volume(

    open val marketDataList: MutableList<MarketData>,
    open val length: Int = 12,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val values: MarketDataValuesProvider = MarketDataValues(marketDataList),

    override val rawIndicator: VolumeIndicator = VolumeIndicator(adapter.toBarSeries(marketDataList), length),
    override val conditions: PositionalConditions = BasePositionalConditions(marketDataList, values)

) : ConditionalIndicator