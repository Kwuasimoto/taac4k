package lib.taac4k.markets.providers.polygon

import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.providers.MarketDataProvider

class Polygon(
    val ticker: String = "AAPL",

    val client: PolygonClient = PolygonClient(),
    val adapter: BaseMarketDataAdapter = MarketDataAdapter(),

    val provider: MarketDataProvider = PolygonDataProvider(client, adapter, ticker = ticker),
)