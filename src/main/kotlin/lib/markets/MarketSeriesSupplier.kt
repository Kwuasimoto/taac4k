package lib.markets

/**
 * ## TA4JBarBuilder
 */
interface MarketSeriesSupplier {    /**
     * I think default implementation here is acceptable
     * Can still be overriden by implemention
     */
    fun marketSeries(): Array<MarketData>
}

