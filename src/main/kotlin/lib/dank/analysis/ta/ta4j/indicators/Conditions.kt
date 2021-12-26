package lib.dank.analysis.ta.ta4j.indicators

interface Conditions<IndicatorType, ConditionsType> {
    val rawIndicator: IndicatorType
    val conditions: ConditionsType
}