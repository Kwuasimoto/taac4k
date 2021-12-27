package lib.dank.markets.data

import lib.dank.analysis.ta.enums.OHLCV
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
     * Includes Volume Weighted Average Price
     */
    open var ohlcv: MutableMap<OHLCV, Double> = mutableMapOf(),

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

