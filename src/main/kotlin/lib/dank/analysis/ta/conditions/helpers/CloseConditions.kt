package lib.dank.analysis.ta.conditions.helpers

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.MarketDataJSON


open class CloseConditions(marketAnalysisListDataJSON: MutableList<MarketDataJSON>) :
    IndicatorConditions(marketAnalysisListDataJSON)


