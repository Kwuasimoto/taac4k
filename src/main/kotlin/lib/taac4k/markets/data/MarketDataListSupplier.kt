package lib.taac4k.markets.data

interface MarketDataListSupplier {
    val newList: MutableList<MarketData> get() = mutableListOf()
}