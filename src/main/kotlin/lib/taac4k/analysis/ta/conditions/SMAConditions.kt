package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.Conditions
import lib.taac4k.markets.data.MarketData

open class SMAConditions(marketAnalysisListDataJSON: MutableList<MarketData>) :
    Conditions(marketAnalysisListDataJSON)