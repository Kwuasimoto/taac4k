package lib.dank.analysis.ta.conditions.helpers

import lib.dank.analysis.ta.Conditions
import lib.dank.markets.data.MarketData

open class VolumeConditions(marketDataList: MutableList<MarketData>) : Conditions(marketDataList)