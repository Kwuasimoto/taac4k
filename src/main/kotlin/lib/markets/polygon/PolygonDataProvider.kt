package lib.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.markets.MarketData
import lib.markets.MarketDataClient
import lib.markets.MarketDataProvider
import lib.markets.polygon.client.PolygonClient

class PolygonDataProvider(
    private val ticker: String,
    // PolygonDataProvider *has a* PolygonBarBuilder *has a* polygonClient
    private val client: MarketDataClient<PolygonRestClient> = PolygonClient(),
    private val converter: PolygonDataAdapter = PolygonDataConverter(),
) : MarketDataProvider() {


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
        return converter.parsePolygonAggregatesDTO(
            client.rest.getAggregatesBlocking(params),
            params
        )
    }

}

