package lib.ta4j.suppliers

interface IndicatorConditionSupplier<ConditionProvider, This>{
    val conditions: ConditionProvider
    fun checkCondition(condition: (it: This) -> ConditionAlertSupplier): ConditionAlertSupplier
}