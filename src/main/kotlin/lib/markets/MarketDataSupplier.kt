package lib.markets

interface MarketDataSupplier {
    fun marketData(marketData: MarketData): MarketData = marketData
}