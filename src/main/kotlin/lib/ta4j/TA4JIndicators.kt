package lib.ta4j
import lib.ta4j.indicators.*
import org.ta4j.core.BarSeries

class TA4JIndicators(
    barSeries: BarSeries,
    val close: Close = Close(barSeries),
    val volume: Volume = Volume(barSeries),
    /**
     * Supply indicators
     */
)




