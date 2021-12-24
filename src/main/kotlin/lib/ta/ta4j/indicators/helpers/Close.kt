package lib.ta.ta4j.indicators.helpers

import lib.ta.IndicatorDecorator
import lib.ta.TestAnnotation
import lib.ta.alerts.ZonedAlert
import lib.ta.conditions.CloseConditions
import lib.ta.ta4j.decorator.BaseIndicator
import lib.ta.ta4j.decorator.ZonedIndicator
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import java.util.function.BooleanSupplier


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
class Close(

    barSeries: BarSeries,

    override val rawIndicator: ClosePriceIndicator = ClosePriceIndicator(barSeries),
    override val conditions: CloseConditions = CloseConditions(rawIndicator),

) : ZonedIndicator<ClosePriceIndicator>(), IndicatorDecorator<ClosePriceIndicator, CloseConditions>


