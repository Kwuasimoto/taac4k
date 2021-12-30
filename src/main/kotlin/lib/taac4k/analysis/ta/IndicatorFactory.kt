package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData

/**
 * Maybe in the future
 */

open class IndicatorFactory : ConditionalIndicatorFactory {
    override fun close(marketDataList: MutableList<MarketData>): Close = Close(marketDataList)
}




