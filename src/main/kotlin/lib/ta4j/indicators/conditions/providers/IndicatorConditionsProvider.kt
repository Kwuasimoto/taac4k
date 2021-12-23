package lib.ta4j.indicators.conditions.providers

import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import org.ta4j.core.BarSeries
import org.ta4j.core.Indicator

/**
 * ### Default Condition Supplier
 */
interface IndicatorConditionsProvider<in T> {
//    /**
//     *
//     */
//    fun barsSince(indicator: T, condition: () -> ConditionAlertSupplier, length: Int): ConditionAlertSupplier

    /**
     * ## Indicator moving down.
     */
    fun isRising(indicator: T, length: Int = 0): ZonedAlert

    /**
     * ## Indicator moving down.
     */
    fun isFalling(indicator: T, length: Int = 0): ZonedAlert

    /**
     * ###
     */
    fun crossOver(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ZonedAlert

    /**
     * ###
     */
    fun crossUnder(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ZonedAlert
//
//
    /**
     * @param checkFrom bar to start the pivot analysis from.
     * @param length bars past [checkFrom].
     */
    fun pivotUp(indicator: T, checkFrom: Int = 1, length: Int = 1): ZonedAlert

    /**
     * @param checkFrom bar to start the pivot analysis from.
     * @param length bars past [checkFrom].
     */
    fun pivotDown(indicator: T, checkFrom: Int = 1, length: Int = 1): ZonedAlert

    /**
     * @param barSeries bars series to compare against
     * @param barIndex which bar to check in [barSeries], is over this.barSeries.
     */
    fun isOver(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ZonedAlert

    /**
     * ### uses ![isOver]
     * @param barSeries bars series to compare against.
     * @param barIndex which bar to check in [barSeries], is under this.barSeries.
     */
    fun isUnder(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ZonedAlert
//
//    fun bullishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBullishDivergence(indicator: T): ConditionAlertSupplier
//
//    fun bearishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBearishDivergence(indicator: T): ConditionAlertSupplier
}