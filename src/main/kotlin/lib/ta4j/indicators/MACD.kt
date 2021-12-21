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
    sma: SMA = SMA()
) : MACDBooleanProvider {
    override val indicator: MACDIndicator
        get() = TODO("Not yet implemented")
    override val nodes: MACDIndicatorNodes
        get() = TODO("Not yet implemented")

    override fun build(): MACDIndicator {

        TODO("Not yet implemented")
    }

    override fun isOver(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }
}