package lib.ta.ta4j.indicators

import lib.ta.IndicatorConditionSupplier
import lib.ta.alerts.ZonedAlert
import lib.ta.conditions.CloseConditions
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

class Close(

    barSeries: BarSeries,

    override val conditions: CloseConditions = CloseConditions(),

    ) : ClosePriceIndicator(barSeries),
    IndicatorConditionSupplier<Close, CloseConditions> {

    override fun checkCondition(condition: (it: Close) -> Boolean): ZonedAlert = ZonedAlert(condition(this))
}


