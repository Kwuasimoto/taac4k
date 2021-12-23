package lib.ta.ta4j.indicators

import lib.ta.alerts.ZonedAlert
import lib.ta.IndicatorConditionSupplier
import lib.ta.conditions.RSIConditions
import org.ta4j.core.indicators.RSIIndicator

class RSI (
    close: Close,
    barCount: Int = 12,

    override val conditions: RSIConditions = RSIConditions()

) : RSIIndicator(close, barCount),
    IndicatorConditionSupplier<RSI, RSIConditions> {

    override fun checkCondition(condition: (it: RSI) -> ZonedAlert): ZonedAlert = condition(this)
}