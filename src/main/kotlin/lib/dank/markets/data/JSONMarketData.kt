package lib.dank.markets.data

import lib.dank.markets.enums.TIMESPAN
import org.json.JSONObject
import java.time.Duration
import java.time.ZonedDateTime

/**
 * @MarketDataJSON
 */
open class JSONMarketData(
    open var ticker: String = "AAPL",

    open var open: Double = 0.00,
    open var high: Double = 0.00,
    open var low: Double = 0.00,
    open var close: Double = 0.00,

    open var volume: Double = 0.00,
    /**
     * Timestamps on bar
     */

    open var endTime: ZonedDateTime = ZonedDateTime.now(),

    /**
     * "minute" | "hour" | "day" | "month"
     */
    open var period: Duration = Duration.ofMinutes(1),

    /**
     * Volume weight average price
     */
    open var vwap: Double = 0.00,

    open var beginTime: Long = ZonedDateTime.now().toEpochSecond(),

    open var timespan: TIMESPAN = TIMESPAN.MINUTE,
    open var multiplier: Long = 1

) : JSONObject() {
    open operator fun set(name: String, value: Any?) {
        this[name] = value
    }
}

