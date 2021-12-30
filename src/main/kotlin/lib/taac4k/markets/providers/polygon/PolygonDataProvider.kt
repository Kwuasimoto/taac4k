package lib.taac4k.markets.providers.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.MarketDataProvider
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter

/**
 * @param client a PolygonClient for accessing endpoints
 * @param ticker the ticker for the PolygonClient to fetch data for.
 *
 * @param adapter [MarketDataAdapter] for converting provided data types to analysis types
 * @version 0.0.1
 */
open class PolygonDataProvider(

    val client: PolygonClient = PolygonClient(),
    val ticker: String = "AAPL",
    override val adapter: MarketDataAdapter = BaseMarketDataAdapter()

) : MarketDataProvider {

    override fun getAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String,
        unadjusted: Boolean,
        limit: Long,
        adapter: MarketDataAdapter
    ): MutableList<MarketData> {
        val params = AggregatesParameters(
            ticker = this.ticker,
            multiplier, timespan, fromDate, toDate, unadjusted, limit
        )

        return adapter.convert(client.rest.getAggregatesBlocking(params), params)
    }
}

