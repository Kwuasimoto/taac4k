package lib.dank.markets

import lib.dank.markets.polygon.Polygon


class Markets(
    val ticker: String = "AAPL",
    val polygon: Polygon = Polygon(ticker)
)