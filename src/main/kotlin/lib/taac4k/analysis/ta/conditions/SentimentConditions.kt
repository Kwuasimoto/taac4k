package lib.taac4k.analysis.ta.conditions

import lib.taac4k.markets.data.MarketData

/**
 * ## SentimentConditions
 * Provides Generic Sentiment Conditions and values for Indicators such as RSI that
 * have the ability to produce oversold or overbought signals, or general sentiment conditions
 */
interface SentimentConditions : PositionalConditions {
    /**
     * is overbought threshold
     */
    val overbought: Int get() = 30
    /**
     * is oversold threshold
     */
    val oversold: Int get() = 70
    /**
     * general sentiment threshold
     */
    val threshold: Int get() = 50
    /**
     * ## isOverbought
     * check if the rsiValue is under the overbought threshold
     * @param rsiValue
     * @return [Boolean]
     */
    fun isOverbought(rsiValue: Int): Boolean
    /**
     * ## isOversold
     * check if the rsiValue is over the oversold threshold
     * @param rsiValue
     * @return [Boolean]
     */
    fun isOversold(rsiValue: Int): Boolean
    /**
     * ## isOverThreshold
     * check if the rsiValue is over the overbought threshold
     * @param rsiValue
     * @return [Boolean]
     */
    fun isOverThreshold(rsiValue: Int): Boolean
    /**
     * ## sentimentCrossOver
     * check if a sentiment cross over occurs (not implemented)
     * @param positionDataList
     * @param negativeDataList
     * @return [Boolean]
     */
    fun sentimentCrossOver(
        positionDataList: MutableList<MarketData>,
        negativeDataList: MutableList<MarketData>
    ): Boolean

}