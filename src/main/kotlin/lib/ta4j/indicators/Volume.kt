package lib.ta4j.indicators

import lib.ta4j.alerts.ZonedAlert
import lib.ta4j.conditions.IndicatorConditionSupplier
import lib.ta4j.conditions.VolumeConditions
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.VolumeIndicator

class Volume(
    barSeries: BarSeries,
    override val conditions: VolumeConditions = VolumeConditions()
) : VolumeIndicator(barSeries), IndicatorConditionSupplier<Volume, VolumeConditions> {

    override fun checkCondition(condition: (it: Volume) -> ZonedAlert): ZonedAlert = condition(this)
}