package lib.taac4k.markets.data

interface MarketDataMutableListSupplier {
    val newList: MutableList<MarketData> get() = mutableListOf()
}