package lib.dank.analysis.ta.alerts

import java.time.ZonedDateTime
import java.util.function.BooleanSupplier

class ZonedAlert(
    private val bool: Boolean,
    val triggeredAt: ZonedDateTime = ZonedDateTime.now()
) : BooleanSupplier {

    override fun getAsBoolean(): Boolean = bool
}



