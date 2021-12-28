package lib.dank.markets.polygon

import lib.dank.markets.data.MarketDataProvider
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter

class Polygon(
    val ticker: String = "AAPL",

    val client: PolygonClient = PolygonClient(),
    val adapter: MarketDataAdapter = BaseMarketDataAdapter(),

    val provider: MarketDataProvider = PolygonDataProvider(client, adapter, ticker = ticker),
)