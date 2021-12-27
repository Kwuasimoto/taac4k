package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.BaseIndicatorConditionsProvider
import lib.dank.markets.data.MarketData

class MACDConditions(marketDataList: MutableList<MarketData>) : BaseIndicatorConditionsProvider(marketDataList)