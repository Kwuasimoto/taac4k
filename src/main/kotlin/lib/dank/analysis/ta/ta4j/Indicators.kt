package lib.dank.analysis.ta.ta4j

import lib.dank.analysis.ta.ta4j.indicators.RSI
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.analysis.ta.ta4j.indicators.helpers.Volume
import lib.dank.markets.data.JSONMarketData

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
    JSONMarketDataList: MutableList<JSONMarketData>,

    volumeLength: Int = 12,
    // Helpers
    val close: Close = Close(JSONMarketDataList),
    val volume: Volume = Volume(JSONMarketDataList, length = volumeLength),

    // Indicators
    val rsi: RSI = RSI(close)
)




