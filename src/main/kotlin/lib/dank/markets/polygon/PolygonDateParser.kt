package lib.dank.markets.polygon

import lib.dank.markets.MarketDateParser
import lib.dank.markets.enums.TIMESPAN
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

open class PolygonDateParser: MarketDateParser {
    override fun parseMillis(millis: Long?): ZonedDateTime {
        if(millis == null) throw IllegalArgumentException("millis null")

        val instant = millis.let { Instant.ofEpochMilli(it) }
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    }

    override fun parseDuration(timespan: TIMESPAN, multiplier: Long): Duration =
        when (timespan) {
            TIMESPAN.MINUTE -> Duration.ofMinutes(multiplier)
            TIMESPAN.HOUR -> Duration.ofHours(multiplier)
            TIMESPAN.DAY -> Duration.ofDays(multiplier)
        }
}
