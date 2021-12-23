package lib.ta4j.indicators

import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import lib.ta4j.indicators.conditions.VolumeConditions
import lib.ta4j.indicators.conditions.suppliers.helpers.VolumeConditionSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.VolumeIndicator

class Volume(
    barSeries: BarSeries,
    override val conditions: VolumeConditions = VolumeConditions()
) : VolumeIndicator(barSeries), VolumeConditionSupplier {

    override fun checkCondition(condition: (it: Volume) -> ZonedAlert): ZonedAlert = condition(this)
}