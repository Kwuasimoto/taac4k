package lib.dank.analysis.ta

import lib.dank.markets.data.MarketData

open class SentimentIndicatorConditionsProvider(
    open val overBought: Int = 70,
    open val overSold: Int = 30,

    marketDataList: MutableList<MarketData>

) : BaseIndicatorConditionsProvider(marketDataList) {



}