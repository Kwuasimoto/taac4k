package lib.ta.ta4j.indicators

import lib.ta.IndicatorDecorator
import lib.ta.conditions.EMAConditions
import lib.ta.ta4j.indicators.decorator.ZonedIndicator
import lib.ta.ta4j.indicators.helpers.Close
import org.ta4j.core.indicators.EMAIndicator

class EMA(close: Close,

    barCount: Int = 12,

    override val rawIndicator: EMAIndicator = EMAIndicator(close.rawIndicator, barCount),
    override val conditions: EMAConditions = EMAConditions(rawIndicator),

) : ZonedIndicator<EMAIndicator>(), IndicatorDecorator<EMAIndicator, EMAConditions>