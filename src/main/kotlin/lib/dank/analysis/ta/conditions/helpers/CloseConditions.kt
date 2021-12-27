package lib.dank.analysis.ta.conditions.helpers

import lib.dank.analysis.ta.BaseIndicatorConditionsProvider
import lib.dank.markets.data.MarketData

open class CloseConditions(marketDataList: MutableList<MarketData>) : BaseIndicatorConditionsProvider(marketDataList)
