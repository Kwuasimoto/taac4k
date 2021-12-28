package lib.taac4k.markets.polygon

import lib.taac4k.markets.MarketDataProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter

class Polygon(
    val ticker: String = "AAPL",

    val client: PolygonClient = PolygonClient(),
    val adapter: BaseMarketDataAdapter = MarketDataAdapter(),

    val provider: MarketDataProvider = PolygonDataProvider(client, adapter, ticker = ticker),
)