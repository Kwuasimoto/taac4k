package lib.taac4k.analysis.ta.conditions

import lib.taac4k.markets.data.MarketData

interface SentimentConditions : PositionalConditions {

    val overbought: Int get() = 30
    val oversold: Int get() = 70
    val threshold: Int get() = 50

    fun isOverbought(rsiValue: Int): Boolean
    fun isOversold(rsiValue: Int): Boolean
    fun isOverThreshold(rsiValue: Int): Boolean
    fun sentimentCrossOver(
        positionDataList: MutableList<MarketData>,
        negativeDataList: MutableList<MarketData>
    ): Boolean

}