package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.BaseConditions
import lib.taac4k.markets.data.MarketData

open class SMAConditions(marketAnalysisListDataJSON: MutableList<MarketData>) :
    BaseConditions(marketAnalysisListDataJSON)