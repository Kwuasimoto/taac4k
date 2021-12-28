package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.Conditions
import lib.dank.markets.data.MarketData

class EMAConditions(marketAnalysisListDataJSON: MutableList<MarketData>) :
    Conditions(marketAnalysisListDataJSON)