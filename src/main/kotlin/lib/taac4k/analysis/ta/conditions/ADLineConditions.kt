package lib.dank.analysis.ta.conditions

import lib.dank.analysis.ta.Conditions
import lib.dank.markets.data.MarketData

/**
 * Accumulation/Distribute Line Conditions
 */
class ADLineConditions(marketDataList: MutableList<MarketData>) : Conditions(marketDataList)