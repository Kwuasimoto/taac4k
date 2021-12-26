package lib.dank.markets.polygon

import lib.dank.markets.data.MarketDataProvider

class Polygon(
    val ticker: String = "AAPL",

    val client: PolygonClient = PolygonClient(),
    val converter: PolygonDataAdapter = PolygonDataAdapter(),

    val provider: MarketDataProvider = PolygonDataProvider(client, converter, ticker = ticker),
)