package lib.taac4k.analysis.ta.conditions.helpers

import lib.taac4k.analysis.ta.BaseConditions
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

open class CloseConditions(
    marketDataList: MutableList<MarketData>,
    override val values: MarketDataValuesProvider = MarketDataValuesProvider(marketDataList)
) : BaseConditions(marketDataList, values)
