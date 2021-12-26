package lib.dank.analysis.ta.ta4j.indicators

interface ConditionsSupplier<IndicatorType, ConditionsType> {
    val indicator: IndicatorType
    val conditions: ConditionsType
}