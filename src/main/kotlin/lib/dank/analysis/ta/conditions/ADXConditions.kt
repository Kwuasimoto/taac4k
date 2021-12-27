package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.BaseIndicatorConditionsProvider
import lib.dank.markets.data.MarketData

class ADXConditions(marketDataList: MutableList<MarketData>) : BaseIndicatorConditionsProvider(marketDataList)