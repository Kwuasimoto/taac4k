package lib.dank.markets

import org.json.JSONObject
import java.time.Duration
import java.time.ZonedDateTime

/**
 * @MarketDataJSON
 */
open class MarketDataJSON(
    val ticker: String,

    val open: Double,
    val high: Double,
    val low: Double,
    val close: Double,

    val volume: Double,
    /**
     * Timestamps on bar
     */

    val endTime: ZonedDateTime,

    /**
     * "minute" | "hour" | "day" | "month"
     */
    val period: Duration,

    /**
     * Volume weight average price
     */
    val vwap: Double,

    val beginTime: Long = ZonedDateTime.now().toEpochSecond()

) : JSONObject()

