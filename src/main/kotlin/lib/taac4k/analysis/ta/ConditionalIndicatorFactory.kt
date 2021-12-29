package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData

interface ConditionalIndicatorFactory {

    fun close(marketDataList: MutableList<MarketData>): Close
}