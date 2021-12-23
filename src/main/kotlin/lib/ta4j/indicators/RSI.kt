package lib.ta4j.indicators

import lib.ta4j.alerts.ZonedAlert
import lib.ta4j.conditions.RSIConditions
import lib.ta4j.conditions.suppliers.RSIConditionSupplier
import org.ta4j.core.indicators.RSIIndicator

class RSI (
    close: Close,
    length: Int = 12,

    override val conditions: RSIConditions = RSIConditions()

) : RSIIndicator(close, length), RSIConditionSupplier {

    override fun checkCondition(condition: (it: RSI) -> ZonedAlert): ZonedAlert = condition(this)
}