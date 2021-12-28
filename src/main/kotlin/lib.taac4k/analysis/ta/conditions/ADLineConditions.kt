package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.BaseConditions
import lib.taac4k.markets.data.MarketData

/**
 * Accumulation/Distribute Line Conditions
 */
open class ADLineConditions(marketDataList: MutableList<MarketData>) : BaseConditions(marketDataList)