package lib

import lib.ta4j.TA4JDataConverter
import org.ta4j.core.num.Num
import java.time.ZonedDateTime
import kotlin.time.Duration


class MarketData(
    // Bar Time Data

    /**
     * Time period of bars ("minute" | "hour" ...)
     * @see [TA4JDataConverter]
     */
    val timeperiod: Duration?,

    /**
     * moment of bar end.
     * @see [TA4JDataConverter]
     */
    val barEnd: ZonedDateTime,


    // Bar OHLC Data
    /**
     * OHLC Data.
     * @see [TA4JDataConverter]
     */
    val OHLC: Map<String, Num>
)