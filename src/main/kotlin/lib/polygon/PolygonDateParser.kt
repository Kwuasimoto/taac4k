package lib.polygon

import lib.ta4j.parser.DateParser
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class PolygonDateParser: DateParser {
    override fun parseMillis(millis: Long?): ZonedDateTime {
        if(millis == null) throw IllegalArgumentException("millis null")

        val instant = millis.let { Instant.ofEpochMilli(it) }
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    }

    override fun parseDuration(timespan: String, multiplier: Long): Duration =
        when (timespan) {
            "minute" -> Duration.ofMinutes(multiplier)
            "hour" -> Duration.ofHours(multiplier)
            "day" -> Duration.ofDays(multiplier)
            else -> throw IllegalArgumentException("Timespan not recognized")
        }
}
