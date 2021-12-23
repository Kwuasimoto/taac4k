package lib.ta.ta4j.indicators

import lib.ta.ta4j.alerts.ZonedAlert
import lib.ta.ta4j.conditions.EMAConditions
import lib.ta.ta4j.conditions.IndicatorConditionSupplier
import org.ta4j.core.indicators.EMAIndicator

class EMA(
    close: Close,
    barCount: Int = 12,

    override val conditions: EMAConditions = EMAConditions()

) : EMAIndicator(close, barCount),
    IndicatorConditionSupplier<EMA, EMAConditions> {

    override fun checkCondition(condition: (it: EMA) -> ZonedAlert): ZonedAlert = condition(this)
}