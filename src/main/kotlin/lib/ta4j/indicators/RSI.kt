package lib.ta4j.indicators

import lib.ta4j.alerts.ZonedAlert
import lib.ta4j.conditions.RSIConditions
import lib.ta4j.conditions.IndicatorConditionSupplier
import org.ta4j.core.indicators.RSIIndicator

class RSI (
    close: Close,
    barCount: Int = 12,

    override val conditions: RSIConditions = RSIConditions()

) : RSIIndicator(close, barCount),
    IndicatorConditionSupplier<RSI, RSIConditions> {

    override fun checkCondition(condition: (it: RSI) -> ZonedAlert): ZonedAlert = condition(this)
}