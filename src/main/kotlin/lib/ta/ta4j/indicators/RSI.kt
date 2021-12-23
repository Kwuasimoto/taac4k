package lib.ta.ta4j.indicators

import lib.ta.alerts.ZonedAlert
import lib.ta.IndicatorConditionSupplier
import lib.ta.conditions.RSIConditions
import org.ta4j.core.Indicator
import org.ta4j.core.indicators.RSIIndicator
import java.util.function.BooleanSupplier

class RSI (
    close: Close,
    barCount: Int = 12,
    indicator: RSIIndicator = RSIIndicator(close, barCount),

    val conditions: RSIConditions = RSIConditions(indicator)
) {
    fun checkCondition(condition: () -> Boolean): BooleanSupplier = ZonedAlert(condition())
}