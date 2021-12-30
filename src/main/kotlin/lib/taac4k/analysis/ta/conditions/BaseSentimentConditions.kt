package lib.taac4k.analysis.ta.conditions

import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider


/**
 * Checks for conditions like overBought, overSold and overThreshold
 */
open class BaseSentimentConditions(
    override val marketDataMutableList: MutableList<MarketData>,
    override val values: MarketDataValuesProvider,

    override val overbought: Int,
    override val oversold: Int,
    override val threshold: Int,

) : BasePositionalConditions(marketDataMutableList, values), SentimentConditions {



    /**
     * Checks if this conditions marketDataList objects value at [rsiValue] is over
     * the [threshold]
     */
    override fun isOverThreshold(rsiValue: Int): Boolean = rsiValue > threshold


    /**
     * Checks if this conditions marketDataList objects value at [rsiValue] is over
     * the [overbought] threshold
     */
    override fun isOverbought(rsiValue: Int): Boolean = rsiValue <= overbought

    /**
     * Checks if this conditions marketDataList objects value at [rsiValue] is under
     * the [oversold] threshold
     */
    override fun isOversold(rsiValue: Int): Boolean = rsiValue >= oversold


    override fun sentimentCrossOver(
        positionDataList: MutableList<MarketData>,
        negativeDataList: MutableList<MarketData>
    ): Boolean { TODO () }

}