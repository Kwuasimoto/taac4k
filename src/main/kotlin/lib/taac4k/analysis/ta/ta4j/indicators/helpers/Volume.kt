package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.conditions.helpers.VolumeConditions
import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.helpers.VolumeIndicator

open class Volume(

    open val marketDataList: MutableList<MarketData>,
    open val length: Int = 12,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val conditions: VolumeConditions = VolumeConditions(marketDataList),
    override val rawIndicator: VolumeIndicator = VolumeIndicator(adapter.toBarSeries(marketDataList), length)

) : IndicatorConditions<VolumeConditions>