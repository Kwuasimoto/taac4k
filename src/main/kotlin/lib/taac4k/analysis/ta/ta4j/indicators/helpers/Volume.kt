package lib.taac4k.analysis.ta.ta4j.indicators.helpers

import lib.taac4k.analysis.ta.conditions.helpers.VolumeConditions
import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.helpers.VolumeIndicator

open class Volume(

    open val marketDataList: MutableList<MarketData>,
    open val length: Int = 12,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val conditions: VolumeConditions = VolumeConditions(marketDataList),
    override val rawIndicator: VolumeIndicator = VolumeIndicator(adapter.toBarSeries(marketDataList), length)

) : IndicatorConditions<VolumeConditions>