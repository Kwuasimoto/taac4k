package lib.ta.ta4j.alerts

interface IndicatorAlert {
    fun alert(bool: () -> Boolean): ZonedAlert = ZonedAlert(bool())
}
