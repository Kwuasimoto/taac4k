package lib.dank.analysis.ta.conditions.helpers

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.MarketDataJSON

class VolumeConditions(marketAnalysisDataList: MutableList<MarketDataJSON>) :
    IndicatorConditions(marketAnalysisDataList)