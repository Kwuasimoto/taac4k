package lib.dank.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.MarketDataJSON
import lib.dank.markets.MarketDataProvider

class PolygonDataProvider(

    val client: PolygonClient = PolygonClient(),
    val adapter: PolygonDataAdapter = PolygonDataAdapter(),

    val ticker: String = "AAPL",

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
    ): MutableList<MarketDataJSON> {
        val params = AggregatesParameters(
            ticker = this.ticker,
            multiplier, timespan, fromDate, toDate, unadjusted, limit
        )

        return adapter.from(client.rest.getAggregatesBlocking(params), params)
    }

}

