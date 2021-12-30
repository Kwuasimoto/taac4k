package lib.taac4k.markets

import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Primary interface for building MarketDataProvider objects like PolygonDataProvider
 */
interface MarketDataProvider {

    /**
     * adapter for assisting in fetched data conversion.
     */
    val adapter: MarketDataAdapter

    /**
     * [timespan] * [multiplier] == period for bars
     *
     * @param multiplier the number multiplier for [timespan]
     * @param timespan the string form of the data duration "minute" | "hour" | "day"
     * @param fromDate the date to start the data fetch
     * @param toDate the date to fetch to
     * @param unadjusted Include stock splits in the results?
     * @param limit the limit of bars to fetch
     * @param adapter convert data from a market data client to be compatible with conditions module
     */
    fun getAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String = SimpleDateFormat("yyyy-MM-dd").format(Date()),
        unadjusted: Boolean = true,
        limit: Long = 5000,
        adapter: MarketDataAdapter = this.adapter
    ): MutableList<MarketData>
}

