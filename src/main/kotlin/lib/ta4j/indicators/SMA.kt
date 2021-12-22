package lib.ta4j.indicators

import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.SMAIndicator
import java.util.function.BooleanSupplier

class SMA (
    val barSeries: BarSeries? = null,
    val close: Close = Close(barSeries),

    private val barLength: Int = 12,
    override val indicator: SMAIndicator = SMAIndicator(close.indicator, barLength)
) : SMABooleanProvider {

    override fun isOver(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }
}