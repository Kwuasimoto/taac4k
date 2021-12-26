package lib.dank.analysis.ta

interface ConditionAlertSupplier {
    fun alert(bool: () -> Boolean): Boolean = bool()
}
