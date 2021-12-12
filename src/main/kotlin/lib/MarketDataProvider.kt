package lib

import lib.ta4j.TA4JDataConverter
import java.util.*

interface MarketDataProvider : TA4JDataConverter {
    /**
     * Because API Limitations, Aggregate data is all we want for now..
     *
     * Every function in this interface should return a List<MarketData>
     *     that will be forwarded to a [TA4JDataConverter] to
     *     be transformed into a BarSeries for the [TA4JBooleanProvider]
     */

    /**
     * @param multiplier applies to timespan.
     *  [barLength = multiplier * timespan]
     * @param timespan "minute" | "hour" | "day" ...
     *  https://polygon.io/docs/stocks/get_v2_aggs_ticker__stocksTicker__range__multiplier___timespan___from___to
     * @param fromDate get bars starting from date
     * @param toDate get bars going to date
     * @param unadjusted adjust bars to stock splits? (no)
     * @param limit How many instances of data do we want? (def: 5000, max: 50000)
     * @return [MarketData] List
     */
    fun getMarketDataForAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String = standardDateFormat.format(Date()),
        unadjusted: Boolean = true,
        limit: Long = 5000,
    ): List<MarketData>
}

