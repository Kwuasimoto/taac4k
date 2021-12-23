package lib.markets.polygon

import org.ta4j.core.BarSeries
import java.text.SimpleDateFormat
import java.util.*

interface MarketDataProvider {
    /**
     * @param multiplier applies to timespan.
     *  [barLength = multiplier * timespan]
     * @param timespan "minute" | "hour" | "day" ...
     *  https://polygon.io/docs/stocks/get_v2_aggs_ticker__stocksTicker__range__multiplier___timespan___from___to
     * @param fromDate get bars starting from date
     * @param toDate get bars going to date
     * @param unadjusted adjust bars to stock splits? (no)
     * @param limit How many instances of data do we want? (def: 5000, max: 50000)
     * @return [BarSeries]
     */
    fun getMarketDataForAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String = SimpleDateFormat("yyyy-MM-dd").format(Date()),
        unadjusted: Boolean = true,
        limit: Long = 5000,
    ): BarSeries
}

