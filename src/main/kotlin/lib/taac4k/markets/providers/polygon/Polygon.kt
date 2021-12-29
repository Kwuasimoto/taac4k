package lib.taac4k.markets.providers.polygon

import lib.taac4k.markets.MarketDataProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter

class Polygon(
    val ticker: String = "AAPL",

    val client: PolygonClient = PolygonClient(),
    val adapter: MarketDataAdapter = BaseMarketDataAdapter(),

    val provider: MarketDataProvider = PolygonDataProvider(client, adapter, ticker = ticker),
)