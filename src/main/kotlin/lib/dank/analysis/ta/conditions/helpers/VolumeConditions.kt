package lib.dank.analysis.ta.conditions.helpers

import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.data.JSONMarketData

class VolumeConditions(marketAnalysisDataList: MutableList<JSONMarketData>) :
    IndicatorConditions(marketAnalysisDataList)