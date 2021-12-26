package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.helpers.VolumeConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.conditions.IndicatorConditions
import lib.dank.analysis.ta.conditions.executor.ZonedConditionsExecutor
import lib.dank.markets.data.JSONMarketData
import org.ta4j.core.indicators.helpers.VolumeIndicator

open class Volume(

    open val JSONMarketDataList: MutableList<JSONMarketData>,
    open val length: Int = 12,

    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val conditions: VolumeConditions = VolumeConditions(JSONMarketDataList),
    override val rawIndicator: VolumeIndicator = VolumeIndicator(adapter.toBarSeries(JSONMarketDataList), length)

) : ZonedConditionsExecutor, IndicatorConditions<VolumeIndicator, VolumeConditions>