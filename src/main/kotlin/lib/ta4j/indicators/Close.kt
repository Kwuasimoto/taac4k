package lib.ta4j.indicators

import lib.ta4j.indicators.alerts.ZonedAlertSupplier
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

    ) : ClosePriceIndicator(barSeries),
    /**
     * alert: = CloseAlertProvider<Close>
     * *hidden* indicator: = Close
     */

    CloseConditionSupplier
{
    /**
     * Individual indicator condition behaviour
     * can be overwritten by checkCondition function.
     */
    override fun checkCondition(
        condition: (it: Close) -> ZonedAlertSupplier

    ): ZonedAlertSupplier =
        condition(this)
}