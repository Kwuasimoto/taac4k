package lib.ta4j.suppliers

import org.ta4j.core.Bar
import java.time.ZonedDateTime
import java.util.function.BooleanSupplier

interface ConditionAlertSupplier : BooleanSupplier {
    val triggeredAt: ZonedDateTime;
    fun bar(time: ZonedDateTime): Bar
}



