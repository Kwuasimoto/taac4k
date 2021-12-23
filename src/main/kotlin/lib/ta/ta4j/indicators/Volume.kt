package lib.ta.ta4j.indicators

import lib.ta.alerts.ZonedAlert
import lib.ta.IndicatorConditionSupplier
import lib.ta.conditions.VolumeConditions
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.VolumeIndicator

class Volume(
    barSeries: BarSeries,
    override val conditions: VolumeConditions = VolumeConditions()
) : VolumeIndicator(barSeries), IndicatorConditionSupplier<Volume, VolumeConditions> {

    override fun checkCondition(condition: (it: Volume) -> ZonedAlert): ZonedAlert = condition(this)
}