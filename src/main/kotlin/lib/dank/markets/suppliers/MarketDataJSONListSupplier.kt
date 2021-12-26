package lib.dank.markets.suppliers

import lib.dank.markets.MarketDataJSON

interface MarketDataJSONListSupplier {
    val newList: MutableList<MarketDataJSON> get() = mutableListOf()
}