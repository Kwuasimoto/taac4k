package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.conditions.executor.ConditionsExecutor

interface IndicatorConditions<IndicatorType, ConditionsType> : ConditionsExecutor {
    val rawIndicator: IndicatorType
    val conditions: ConditionsType
}