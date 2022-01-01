package lib.taac4k.markets.data.factory

import lib.taac4k.markets.data.enums.TIMESPAN
import java.time.Duration
import java.time.ZonedDateTime

/**
 * ## MarketDateParser Interface
 * provides methods for finding [Date] values from [Long]'s and [TIMESPAN].
 */
interface MarketDateParser {
    /**
     * ## toZonedDateTime
     * @param millis millis values
     * @return [ZonedDateTime]
     */
    fun toZonedDateTime(millis: Long?): ZonedDateTime
    /**
     * ## toDuration
     * @param timespan "minute" | "hour" | "day"
     * @param multiplier number multiplier to find Duration {.ofDays(multiplier)}
     */
    fun toDuration(timespan: TIMESPAN, multiplier: Long): Duration
}