package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.BaseIndicatorConditionsProvider
import lib.dank.markets.data.MarketData

open class SMAConditions(marketAnalysisListDataJSON: MutableList<MarketData>) :
    BaseIndicatorConditionsProvider(marketAnalysisListDataJSON)