package lib.dank.markets.data

import java.text.SimpleDateFormat
import java.util.*

interface MarketDataProvider {
    val adapter: MarketDataAdapter

    fun getAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String = SimpleDateFormat("yyyy-MM-dd").format(Date()),
        unadjusted: Boolean = true,
        limit: Long = 5000,
        // Providing polygonClient to polygonBarBuilder delegates hidden call to
        // Polygon bar builder
        adapter: MarketDataAdapter = this.adapter
    ): MutableList<JSONMarketData>

}

