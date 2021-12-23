package lib.ta4j.indicators

import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import lib.ta4j.indicators.conditions.CloseConditions
import lib.ta4j.indicators.conditions.suppliers.helpers.CloseConditionSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator

/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */


class Close(

    barSeries: BarSeries,
    override val conditions: CloseConditions = CloseConditions(),

) : ClosePriceIndicator(barSeries), CloseConditionSupplier {

    override fun checkCondition(condition: (it: Close) -> ZonedAlert): ZonedAlert = condition(this)
}