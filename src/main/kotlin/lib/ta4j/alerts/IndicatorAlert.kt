package lib.ta4j.alerts

interface IndicatorAlert {
    fun alert(bool: () -> Boolean): ZonedAlert = ZonedAlert(bool())
}
