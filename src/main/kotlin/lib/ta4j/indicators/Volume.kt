package lib.ta4j.indicators

import lib.ta4j.suppliers.helpers.VolumeConditionSupplier
import lib.ta4j.suppliers.ConditionAlertSupplier
import lib.ta4j.suppliers.IndicatorConditionSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.VolumeIndicator

class Volume(
    barSeries: BarSeries,
    barLength: Int = 12,

    override val conditions: VolumeConditionSupplier = VolumeConditionSupplier()
) : VolumeIndicator(barSeries, barLength), IndicatorConditionSupplier<VolumeConditionSupplier, Volume> {

    override fun checkCondition(
        condition: (it: Volume) -> ConditionAlertSupplier

    ): ConditionAlertSupplier =
        condition(this)
}