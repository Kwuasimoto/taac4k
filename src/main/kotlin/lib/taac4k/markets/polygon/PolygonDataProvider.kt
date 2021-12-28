package lib.taac4k.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.MarketDataProvider
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter

open class PolygonDataProvider(

    open val client: PolygonClient = PolygonClient(),
    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),

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
    ): MutableList<MarketData> {
        val params = AggregatesParameters(
            ticker = this.ticker,
            multiplier, timespan, fromDate, toDate, unadjusted, limit
        )

        return adapter.convert(client.rest.getAggregatesBlocking(params), params)
    }
}

