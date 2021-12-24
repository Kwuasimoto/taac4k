package lib.ta.ta4j.indicators.helpers

import lib.ta.IndicatorDecorator
import lib.ta.conditions.CloseConditions
import lib.ta.ta4j.indicators.decorator.ZonedIndicator
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
class Close(

    barSeries: BarSeries,

    override val rawIndicator: ClosePriceIndicator = ClosePriceIndicator(barSeries),
    override val conditions: CloseConditions = CloseConditions(rawIndicator),

) : ZonedIndicator<ClosePriceIndicator>(), IndicatorDecorator<ClosePriceIndicator, CloseConditions>


