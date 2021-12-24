package lib.markets

import java.time.Duration
import java.time.ZonedDateTime

/**
 * JSON Friendly, Generic Market Data Close
 *
 * If a Market API Can't supply these basic variables,
 * Don't bother with it.
 */
data class MarketData (
    val ticker: String?,

    val open: Double?,
    val high: Double?,
    val low: Double?,
    val close: Double?,

    val volume: Double?,

    /**
     * Timestamps on bar
     */
    val timestamp: Long?,
    val endTime: ZonedDateTime?,

    /**
     * "minute" | "hour" | "day" | "month"
     */
    val period: Duration?,

    /**
     * Volume weight average price
     */
    val vwap: Double?
)