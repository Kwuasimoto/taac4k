package lib.ta4j.indicators.conditions.providers

import lib.ta4j.indicators.alerts.ZonedAlertSupplier

/**
 * ### Default Condition Supplier
 */
interface IndicatorConditionsProvider<T> {
//    /**
//     *
//     */
//    fun barsSince(indicator: T, condition: () -> ConditionAlertSupplier, length: Int): ConditionAlertSupplier

    /**
     * ## Indicator moving down.
     */
    fun movingUp(indicator: T, length: Int = 0): ZonedAlertSupplier

    /**
     * ## Indicator moving down.
     */
    fun movingDown(indicator: T, length: Int = 0): ZonedAlertSupplier

//    /**
//     * ###
//     */
//    fun crossOver(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ConditionAlertSupplier
//
//    /**
//     * ###
//     */
//    fun crossUnder(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ConditionAlertSupplier
//
//
//    /**
//     * @param checkFrom bar to start the pivot analysis from.
//     * @param length bars past [checkFrom].
//     */
//    fun pivotUp(indicator: T, checkFrom: Int = 1, length: Int = 1): ConditionAlertSupplier
//
//    /**
//     * @param checkFrom bar to start the pivot analysis from.
//     * @param length bars past [checkFrom].
//     */
//    fun pivotDown(indicator: T, checkFrom: Int = 1, length: Int = 1): ConditionAlertSupplier
//
//    /**
//     * @param barSeries bars series to compare against
//     * @param barIndex which bar to check in [barSeries], is over this.barSeries.
//     */
//    fun isOver(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ConditionAlertSupplier
//
//    /**
//     * ### uses ![isOver]
//     * @param barSeries bars series to compare against.
//     * @param barIndex which bar to check in [barSeries], is under this.barSeries.
//     */
//    fun isUnder(indicator: T, barSeries: BarSeries, barIndex: Int = 0, length: Int = 0): ConditionAlertSupplier
//
//    fun bullishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBullishDivergence(indicator: T): ConditionAlertSupplier
//
//    fun bearishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBearishDivergence(indicator: T): ConditionAlertSupplier
}