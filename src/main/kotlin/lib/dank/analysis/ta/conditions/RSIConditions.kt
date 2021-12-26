package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.MarketDataJSON

class RSIConditions(marketAnalysisListDataJSON: MutableList<MarketDataJSON>) :
    IndicatorConditions(marketAnalysisListDataJSON)
