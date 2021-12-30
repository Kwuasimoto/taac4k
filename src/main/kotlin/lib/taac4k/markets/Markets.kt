package lib.taac4k.markets

import lib.taac4k.markets.providers.polygon.Polygon

/**
 * ## Markets
 * Base Markets object for instantiating MarketDataProviders
 *
 * @TODO turn into a market factory
 */
class Markets(
    val ticker: String = "AAPL",
    val polygon: Polygon = Polygon(ticker)
)