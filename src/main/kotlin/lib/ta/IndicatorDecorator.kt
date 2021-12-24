package lib.ta

interface IndicatorDecorator<IndicatorType, ConditionsType> {
    val rawIndicator: IndicatorType
    val conditions: ConditionsType
}