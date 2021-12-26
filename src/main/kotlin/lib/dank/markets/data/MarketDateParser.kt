package lib.dank.markets.data

import lib.dank.markets.enums.TIMESPAN
import java.time.Duration
import java.time.ZonedDateTime

/**
 * I think kotlin allows default implementations of interfaces,
 * which only saves you from writing one class
 */
interface MarketDateParser {
    fun parseMillis(millis: Long?): ZonedDateTime
    fun parseDuration(timespan: TIMESPAN, multiplier: Long): Duration
}