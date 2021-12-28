package lib.taac4k.analysis.ta.conditions.helpers

import lib.taac4k.analysis.ta.Conditions
import lib.taac4k.markets.data.MarketData

open class CloseConditions(marketDataList: MutableList<MarketData>) : Conditions(marketDataList)
