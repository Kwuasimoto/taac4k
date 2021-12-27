package lib.dank.markets.data

import lib.dank.markets.data.MarketData

interface MarketDataListSupplier {
    val newList: MutableList<MarketData> get() = mutableListOf()
}