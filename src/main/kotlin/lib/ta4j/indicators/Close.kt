package lib.ta4j.indicators

import lib.ta4j.alerts.ZonedAlert
import lib.ta4j.conditions.helpers.CloseConditions
import org.ta4j.core.BarSeries
import lib.ta4j.conditions.IndicatorConditionSupplier
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */


class Close(

    barSeries: BarSeries,

    override val conditions: CloseConditions = CloseConditions(),

) : ClosePriceIndicator(barSeries),
    IndicatorConditionSupplier<Close, CloseConditions> {

    override fun checkCondition(condition: (it: Close) -> ZonedAlert): ZonedAlert = condition(this)
}