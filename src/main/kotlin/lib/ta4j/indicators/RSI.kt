package lib.ta4j.indicators

import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import lib.ta4j.indicators.conditions.RSIConditions
import lib.ta4j.indicators.conditions.suppliers.RSIConditionSupplier
import org.ta4j.core.indicators.RSIIndicator

class RSI (
    close: Close,
    length: Int = 12,

    override val conditions: RSIConditions = RSIConditions()

) : RSIIndicator(close, length), RSIConditionSupplier {

    override fun checkCondition(condition: (it: RSI) -> ZonedAlert): ZonedAlert = condition(this)
}