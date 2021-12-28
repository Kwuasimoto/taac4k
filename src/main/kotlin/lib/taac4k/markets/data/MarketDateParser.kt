package lib.taac4k.markets.data

import lib.taac4k.markets.data.enums.TIMESPAN
import java.time.Duration
import java.time.ZonedDateTime

/**
 * I think kotlin allows default implementations of interfaces,
 * which only saves you from writing one class
 */
interface MarketDateParser {
    fun toZonedDateTime(millis: Long?): ZonedDateTime
    fun toDuration(timespan: TIMESPAN, multiplier: Long): Duration
}