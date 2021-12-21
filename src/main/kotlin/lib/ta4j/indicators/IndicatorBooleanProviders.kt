package lib.ta4j.indicators

import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.MACDIndicator
import org.ta4j.core.indicators.SMAIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import java.util.function.BooleanSupplier



interface IndicatorBooleanProvider<T, C> {
    val indicator: T
    val nodes: C
    fun build(): T
    fun isOver(barSeries: BarSeries, barIndex: Int = 0): BooleanSupplier
    fun isUnder(barSeries: BarSeries, barIndex: Int = 0): BooleanSupplier
}

/**
 * TA4J HELPER INDICATORS
 */
interface CloseBooleanProvider : IndicatorBooleanProvider<ClosePriceIndicator, Unit>

/**
 * TA4J INDICATORS
 */
interface SMABooleanProvider : IndicatorBooleanProvider<SMAIndicator, SMAIndicatorNodes>
interface MACDBooleanProvider : IndicatorBooleanProvider<MACDIndicator, MACDIndicatorNodes>

