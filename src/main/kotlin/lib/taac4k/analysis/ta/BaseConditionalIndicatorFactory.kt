package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketData

/**
 * ## Lunos Indicators Class
 *
 * *Helpers*
 * - Close
 * - Volume
 *
 * *Indicators*
 * 1. RSI
 * 2. SMA
 * 3. EMA
 * 4. VWMA
 * 5. PSAR
 * 6. ADX
 * 7. STOCH (Bonus if I get to it today)
 * 8. On-Balance Volume
 */

open class BaseConditionalIndicatorFactory : ConditionalIndicatorFactory {
    override fun close(marketDataList: MutableList<MarketData>): Close = Close(marketDataList)
}




