package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.data.JSONMarketData

class RSIConditions(marketAnalysisListDataJSON: MutableList<JSONMarketData>) :
    IndicatorConditions(marketAnalysisListDataJSON)
