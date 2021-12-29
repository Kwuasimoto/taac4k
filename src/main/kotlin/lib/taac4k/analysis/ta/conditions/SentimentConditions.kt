package lib.taac4k.analysis.ta.conditions

import lib.taac4k.markets.data.MarketData

interface SentimentConditions : PositionalConditions {

    val overBought: Int get() = 30
    val overSold: Int get() = 70
    val threshold: Int get() = 50

    fun isOverBought(index: Int): Boolean
    fun isOverSold(index: Int): Boolean
    fun overThreshold(index: Int): Boolean
    fun sentimentCrossOver(
        positionDataList: MutableList<MarketData>,
        negativeDataList: MutableList<MarketData>
    ): Boolean

}