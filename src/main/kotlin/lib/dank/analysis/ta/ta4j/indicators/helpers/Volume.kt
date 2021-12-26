package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.helpers.VolumeConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.ta4j.indicators.Conditions
import lib.dank.analysis.ta.ta4j.indicators.decorators.WithZonedCondition
import lib.dank.markets.MarketDataJSON
import org.ta4j.core.indicators.helpers.VolumeIndicator

open class Volume(

    open val marketDataJSONList: MutableList<MarketDataJSON>,
    open val length: Int = 12,

    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val conditions: VolumeConditions = VolumeConditions(marketDataJSONList),
    override val rawIndicator: VolumeIndicator = VolumeIndicator(adapter.toBarSeries(marketDataJSONList), length)

) : WithZonedCondition, Conditions<VolumeIndicator, VolumeConditions>