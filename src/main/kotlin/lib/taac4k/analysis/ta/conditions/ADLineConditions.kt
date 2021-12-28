package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.BaseConditions
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider

/**
 * Accumulation/Distribute Line Conditions
 */
open class ADLineConditions(
    override val marketDataMutableList: MutableList<MarketData>,

    override val values: MarketDataValuesProvider = MarketDataValues(marketDataMutableList)
) : BaseConditions(marketDataMutableList)