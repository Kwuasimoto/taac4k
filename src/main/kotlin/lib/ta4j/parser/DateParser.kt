package lib.ta4j.parser
import java.time.Duration
import java.time.ZonedDateTime

/**
 * I think kotlin allows default implementations of interfaces,
 * which only saves you from writing one class
 */
interface DateParser {
    fun parseMillis(millis: Long?): ZonedDateTime
    fun parseDuration(timespan: String, multiplier: Long): Duration
}