package lib.dank.analysis.ta

import lib.dank.markets.data.JSONMarketData
import org.ta4j.core.BarSeries

interface MarketAnalysisAdapter {
    fun toBarSeries(JSONMarketDataList: MutableList<JSONMarketData>, name: String = "Lunos"): BarSeries? = null
}
