package lib.ta4j.indicators.alerts

import java.time.ZonedDateTime
import java.util.function.BooleanSupplier

class ZonedAlertSupplier(
    private val bool: Boolean,
    val triggeredAt: ZonedDateTime = ZonedDateTime.now()
) : BooleanSupplier {

    override fun getAsBoolean(): Boolean = bool
}



