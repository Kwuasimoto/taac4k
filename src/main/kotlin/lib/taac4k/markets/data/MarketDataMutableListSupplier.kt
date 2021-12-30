package lib.taac4k.markets.data

/**
 * Supplier interface for providing empty mutable lists for the conditions' module.
 */
interface MarketDataMutableListSupplier {
    /**
     * The new list to insert data into.
     */
    val newList: MutableList<MarketData> get() = mutableListOf()
}