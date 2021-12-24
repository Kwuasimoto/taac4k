package lib.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.markets.MarketData
import lib.markets.MarketDataProvider
import lib.markets.polygon.client.PolygonClient

class PolygonDataProvider (
    private val ticker: String,
    // PolygonDataProvider *has a* PolygonBarBuilder *has a* polygonClient
    private val polygon: PolygonClient = PolygonClient(),
    private val adapter: PolygonDataAdapter = PolygonDataAdapter(),
): MarketDataProvider {

    override fun getMarketDataForAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String,
        unadjusted: Boolean,
        limit: Long,
        // Providing polygonClient to polygonBarBuilder delegates hidden call to
        // Polygon bar builder
    ): MutableList<MarketData> {
        val params = AggregatesParameters(
            ticker = this.ticker,
            multiplier, timespan, fromDate, toDate, unadjusted, limit
        )

        return adapter.parsePolygonAggregatesDTO(
            polygon.restClient.getAggregatesBlocking(params),
            params
        )
    }

}

