package lib.dank.analysis.ta.ta4j

import lib.dank.analysis.ta.ta4j.indicators.RSI
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.analysis.ta.ta4j.indicators.helpers.Volume
import lib.dank.markets.data.MarketData

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

class Indicators(
    MarketDataList: MutableList<MarketData>,

    volumeLength: Int = 12,
    // Helpers
    val close: Close = Close(MarketDataList),
    val volume: Volume = Volume(MarketDataList, length = volumeLength),

    // Indicators
    val rsi: RSI = RSI(close)
)




