package lib.taac4k.markets.providers.polygon

import lib.taac4k.markets.MarketDataProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter

/**
 * Main Polygon Class
 * @version 0.0.1
 *
 * @param ticker The ticker that polygon will focus when performing a data fetch.
 * @param client Polygon API Client
 * @param adapter Market data adapter for helping polygon convert its return data to MutableList<MarketData>
 * @param provider The Concrete PolygonDataProvider object that handles data fetching and conversion.
 */
class Polygon(
    val ticker: String = "AAPL",

    val client: PolygonClient = PolygonClient(),
    val adapter: MarketDataAdapter = BaseMarketDataAdapter(),

    val provider: MarketDataProvider = PolygonDataProvider(client, ticker, adapter),
)