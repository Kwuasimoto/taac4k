package lib.taac4k.markets

import lib.taac4k.markets.polygon.Polygon

class Markets(
    val ticker: String = "AAPL",
    val polygon: Polygon = Polygon(ticker)
)