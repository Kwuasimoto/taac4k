package lib.dank.analysis.ta.ta4j.indicators.decorators

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.alerts.ZonedAlert

interface WithZonedCondition : WithConditions {
    fun checkConditionZoned(condition: () -> Boolean): ZonedAlert = ZonedAlert(condition())
}