package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLCV
import java.time.ZonedDateTime

/**
 * ## MarketData
 *
 * @param ticker The ticker associated to this piece of market data
 * @param ohlcv open, high, low, close, vwap, values
 * @param volume amount of volume between [endTime] and [beginTime]
 * @param endTime defaults to now()
 * @param beginTime defaults to now() - 60000 (minute bars)
 * @param timespan timespan of the bar, "minute" | "hour" | "day" | "week"
 * @param multiplier [timespan]*[multiplier] where multiplier == 3 will result in 3 minute bars.
 */
open class MarketData(
    /**
     * Bar Ticker
     */
    open var ticker: String = "AAPL",
    /**
     * Important Stuff
     */
    open var ohlcv: MutableMap<OHLCV, Double> = mutableMapOf(),
    open var volume: Double = 0.0,
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

