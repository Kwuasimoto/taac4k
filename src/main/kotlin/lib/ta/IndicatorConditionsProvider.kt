package lib.ta

import org.ta4j.core.BarSeries

/**
 * ### Default Condition Supplier
 */
interface IndicatorConditionsProvider : IndicatorAlert {
//    /**
//     *
//     */
//    fun barsSince condition: () -> ConditionAlertSupplier, length: Int): ConditionAlertSupplier

    fun percentChanged(
        change: Float,
        barIndex: Int = 0,
        period: Int = 0
    ): Boolean

    /**
     * ## Indicator moving down.
     */
    fun isRising(
        numOfBars: Int = 0
    ): Boolean

    /**
     * ## Indicator moving down.
     */
    fun isFalling(
        numOfBars: Int = 0
    ): Boolean

    /**
     * @param barSeries bars series to compare against
     * @param barIndex which bar to check in [barSeries], is over this.barSeries.
     */
    fun isOver(
        barSeries: BarSeries,
        barIndex: Int = 0,
        length: Int = 0
    ): Boolean

    /**
     * ### uses ![isOver]
     * @param barSeries bars series to compare against.
     * @param barIndex which bar to check in [barSeries], is under this.barSeries.
     */
    fun isUnder(
        barSeries: BarSeries,
        barIndex: Int = 0,
        length: Int = 0
    ): Boolean

    /**
     * ###
     */
    fun crossOver(
        barSeries: BarSeries,
        barIndex: Int = 0,
        period: Int = 0
    ): Boolean

    /**
     * ###
     */
    fun crossUnder(
        barSeries: BarSeries,
        barIndex: Int = 0,
        length: Int = 0
    ): Boolean

    /**
     * @param checkFrom bar to start the pivot analysis from.
     * @param length bars past [checkFrom].
     */
    fun pivotUp(
        checkFrom: Int = 1,
        length: Int = 1
    ): Boolean

    /**
     * @param checkFrom bar to start the pivot analysis from.
     * @param length bars past [checkFrom].
     */
    fun pivotDown(
        checkFrom: Int = 1,
        length: Int = 1
    ): Boolean

//
//    fun bullishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBullishDivergence(indicator: T): ConditionAlertSupplier
//
//    fun bearishDivergence(indicator: T): ConditionAlertSupplier
//    fun hiddenBearishDivergence(indicator: T): ConditionAlertSupplier
}