package lib.dank.markets.suppliers

import lib.dank.markets.data.JSONMarketData

interface MarketDataJSONListSupplier {
    val newList: MutableList<JSONMarketData> get() = mutableListOf()
}