package lib.markets

import lib.markets.polygon.PolygonDataAdapter

interface MarketDataAdapter :
    PolygonDataAdapter
    // Add adapters here,
{
    val date: DateParser
}