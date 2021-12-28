package lib.taac4k.markets.data.factory

import lib.taac4k.markets.data.enums.TIMESPAN
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

open class DateParser: MarketDateParser {
    override fun toZonedDateTime(millis: Long?): ZonedDateTime {
        if(millis == null) throw IllegalArgumentException("millis null")

        val instant = millis.let { Instant.ofEpochMilli(it) }
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    }

    override fun toDuration(timespan: TIMESPAN, multiplier: Long): Duration =
        when (timespan) {
            TIMESPAN.MINUTE -> Duration.ofMinutes(multiplier)
            TIMESPAN.HOUR -> Duration.ofHours(multiplier)
            TIMESPAN.DAY -> Duration.ofDays(multiplier)
        }
}
