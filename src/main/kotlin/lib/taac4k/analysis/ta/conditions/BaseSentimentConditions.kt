package lib.taac4k.analysis.ta.conditions

import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

/**
 * Checks for conditions like overBought, overSold and overThreshold
 */
open class BaseSentimentConditions(
    override val marketDataMutableList: MutableList<MarketData>,
    override val values: MarketDataValuesProvider,

    override val overBought: Int,
    override val overSold: Int,
    override val threshold: Int

) : BasePositionalConditions(marketDataMutableList, values), SentimentConditions {

    /**
     * Checks if this conditions marketDataList objects value at [index] is over
     * the [overBought] threshold
     */
    override fun isOverBought(index: Int): Boolean { TODO() }

    /**
     * Checks if this conditions marketDataList objects value at [index] is under
     * the [overSold] threshold
     */
    override fun isOverSold(index: Int): Boolean { TODO() }

    /**
     * Checks if this conditions marketDataList objects value at [index] is over
     * the [threshold]
     */
    override fun overThreshold(index: Int): Boolean { TODO() }

    override fun sentimentCrossOver(
        positionDataList: MutableList<MarketData>,
        negativeDataList: MutableList<MarketData>
    ): Boolean { TODO () }

}