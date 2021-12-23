package lib.ta.ta4j.decorator

import lib.ta.IndicatorConditionSupplier
import lib.ta.alerts.ZonedAlert
import org.ta4j.core.Indicator
import java.util.function.BooleanSupplier

class TimedIndicator<I, T>(
    private val indicator: IndicatorConditionSupplier<I, T>,
) {
    fun checkCondition(condition: (it: I) -> Boolean): ZonedAlert {
        return ZonedAlert(indicator.checkCondition(condition).asBoolean)
    }
}