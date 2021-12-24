package lib.ta.ta4j.indicators.decorator

import lib.ta.alerts.ZonedAlert

open class ZonedIndicator<IndicatorType> : BaseIndicator<IndicatorType>() {
    fun checkConditionZoned(condition: () -> Boolean): ZonedAlert = ZonedAlert(condition())
}