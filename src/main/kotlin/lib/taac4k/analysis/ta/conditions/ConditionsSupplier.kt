package lib.taac4k.analysis.ta.conditions

import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

interface ConditionsSupplier {
    val marketDataMutableList: MutableList<MarketData>
    val values: MarketDataValuesProvider
}