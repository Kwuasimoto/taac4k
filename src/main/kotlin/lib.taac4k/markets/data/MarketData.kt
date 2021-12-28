package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLC
import java.time.ZonedDateTime

/**
 * @MarketDataJSON
 */
open class MarketData(
    /**
     * Bar Ticker
     */
    open var ticker: String = "AAPL",

    /**
     * Important Stuff
     */
    open var ohlc: MutableMap<OHLC, Double> = mutableMapOf(),
    open var volume: Double = 0.0,
    open var vwap: Double = 0.0,

    /**
     * Timestamps on bar
     */
    open var endTime: Long = ZonedDateTime.now().toEpochSecond(),
    open var beginTime: Long = endTime - 60000,

    /**
     * "minute" | "hour" | "day" | "month"
     */
    open var timespan: String = "minute",
    open var multiplier: Long = 1
)

