package lib.ta4j.indicators

import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.MACDIndicator
import java.util.function.BooleanSupplier

/**
 * Yes No ?
 */
//fun MACDIndicator.isOver(barSeries: BarSeries, barIndex: Int = 0) =
//    this.barSeries.lastBar.closePrice > barSeries.getBar(barIndex).closePrice

class MACD(
    val barSeries: BarSeries? = null,
    val shortLength: Int = 12,
    val longLength: Int = 26,

    val close: Close = Close(barSeries),
    val sma: SMA = SMA(close = close),

    override val indicator: MACDIndicator =
        MACDIndicator(sma.indicator, shortLength, longLength),

) : MACDBooleanProvider {

    override fun isOver(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        println("IS OVER FN CALLED")
        TODO("Finish implementation")
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }
}