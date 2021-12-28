package lib.taac4k.analysis.ta

import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.MarketDataAdapter

interface BaseIndicatorFactory {
    val marketDataList: MutableList<MarketData>
    val adapter: MarketDataAdapter
}