package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.MarketDataJSON

class EMAConditions(marketAnalysisListDataJSON: MutableList<MarketDataJSON>) :
    IndicatorConditions(marketAnalysisListDataJSON)