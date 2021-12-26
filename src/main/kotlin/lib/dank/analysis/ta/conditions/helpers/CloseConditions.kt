package lib.dank.analysis.ta.conditions.helpers

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.data.JSONMarketData


open class CloseConditions(marketAnalysisListDataJSON: MutableList<JSONMarketData>) :
    IndicatorConditions(marketAnalysisListDataJSON)


