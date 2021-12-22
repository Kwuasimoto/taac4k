package lib.ta4j
import lib.ta4j.indicators.*
import org.ta4j.core.BarSeries

interface ITA4JBooleanProvider {
    val close: Close
    val macd: MACD
    val sma: SMA /* NOT IMPLEMENTED */
}

open class TA4JIndicators(
    barSeries: BarSeries,
    override val close: Close = Close(barSeries),
    override val sma: SMA = SMA(close = close),
    override val macd: MACD = MACD(sma = sma),
    /**
     * Supply indicators
     */
) : ITA4JBooleanProvider




