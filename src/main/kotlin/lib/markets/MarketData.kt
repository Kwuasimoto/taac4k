package lib.markets

import java.time.Duration
import java.time.ZonedDateTime

data class MarketData(
    val ticker: String?,

    val open: Double?,
    val high: Double?,
    val low: Double?,
    val close: Double?,

    val volume: Double?,

    val timestamp: Long?,
    val endTime: ZonedDateTime?,
    val period: Duration?,

    val vwap: Double?
)