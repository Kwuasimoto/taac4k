package lib.dank.analysis.ta

import lib.dank.markets.MarketDataJSON
import org.ta4j.core.BarSeries

interface MarketAnalysisAdapter {
    fun toBarSeries(marketDataJSONList: MutableList<MarketDataJSON>, name: String = "Lunos"): BarSeries
}
