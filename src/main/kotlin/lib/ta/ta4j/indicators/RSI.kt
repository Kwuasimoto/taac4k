package lib.ta.ta4j.indicators

import lib.ta.IndicatorDecorator
import lib.ta.alerts.ZonedAlert
import lib.ta.conditions.CloseConditions
import lib.ta.conditions.RSIConditions
import lib.ta.ta4j.decorator.ZonedIndicator
import lib.ta.ta4j.indicators.helpers.Close
import org.ta4j.core.indicators.RSIIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import java.util.function.BooleanSupplier

class RSI (close: Close,

    barCount: Int = 12,

    override val rawIndicator: RSIIndicator = RSIIndicator(close.rawIndicator, barCount),
    override val conditions: RSIConditions = RSIConditions(rawIndicator)

) : ZonedIndicator<ClosePriceIndicator>(), IndicatorDecorator<RSIIndicator, RSIConditions>