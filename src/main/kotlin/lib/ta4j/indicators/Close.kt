package lib.ta4j.indicators

import lib.ta4j.suppliers.helpers.CloseConditionSupplier
import lib.ta4j.suppliers.ConditionAlertSupplier
import lib.ta4j.suppliers.IndicatorConditionSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator

/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */


class Close(

    barSeries: BarSeries,
    override val conditions: CloseConditionSupplier = CloseConditionSupplier(),

    ) : ClosePriceIndicator(barSeries),
    /**
     * alert: = CloseAlertProvider<Close>
     * *hidden* indicator: = Close
     */
    IndicatorConditionSupplier<CloseConditionSupplier, Close> {

    /**
     * Individual indicator condition behaviour
     * can be overwritten by checkCondition function.
     */
    override fun checkCondition(
        condition: (it: Close) -> ConditionAlertSupplier

    ): ConditionAlertSupplier =
        condition(this)
}