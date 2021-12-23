package lib.ta4j.indicators
import lib.ta4j.indicators.Close
import org.ta4j.core.BarSeries

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
    barSeries: BarSeries,

    // Helpers
    val close: Close = Close(barSeries),
    val volume: Volume = Volume(barSeries),



    // Indicators
    val rsi: RSI = RSI(close)
)




