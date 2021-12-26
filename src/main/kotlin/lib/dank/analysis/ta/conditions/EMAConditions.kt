package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.data.JSONMarketData

class EMAConditions(marketAnalysisListDataJSON: MutableList<JSONMarketData>) :
    IndicatorConditions(marketAnalysisListDataJSON)