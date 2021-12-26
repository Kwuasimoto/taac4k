package lib.dank.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.data.MarketDataAdapter
import lib.dank.markets.data.MarketDataProvider

open class PolygonDataProvider(

    open val client: PolygonClient = PolygonClient(),
    override val adapter: PolygonDataAdapter = PolygonDataAdapter(),

    open val ticker: String = "AAPL",

    ) : MarketDataProvider {

    override fun getAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String,
        unadjusted: Boolean,
        limit: Long,
        // Providing polygonClient to polygonBarBuilder delegates hidden call to
        // Polygon bar builder
        adapter: MarketDataAdapter
    ): MutableList<JSONMarketData> {
        val params = AggregatesParameters(
            ticker = this.ticker,
            multiplier, timespan, fromDate, toDate, unadjusted, limit
        )

        println(adapter)
        return adapter.from(client.rest.getAggregatesBlocking(params), params)
    }
}

