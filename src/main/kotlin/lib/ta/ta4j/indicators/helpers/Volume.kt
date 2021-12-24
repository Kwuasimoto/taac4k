package lib.ta.ta4j.indicators.helpers

import lib.ta.IndicatorDecorator
import lib.ta.conditions.VolumeConditions
import lib.ta.ta4j.indicators.decorator.ZonedIndicator
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.VolumeIndicator

class Volume(

    barSeries: BarSeries,

    override val rawIndicator: VolumeIndicator = VolumeIndicator(barSeries),
    override val conditions: VolumeConditions = VolumeConditions(rawIndicator),

) : ZonedIndicator<VolumeIndicator>(), IndicatorDecorator<VolumeIndicator, VolumeConditions>