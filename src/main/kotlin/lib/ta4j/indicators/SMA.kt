package lib.ta4j.indicators

import org.ta4j.core.BarSeries
import org.ta4j.core.Indicator
import org.ta4j.core.indicators.SMAIndicator
import java.util.function.BooleanSupplier

class SMA () : SMABooleanProvider {
    override val indicator: SMAIndicator
        get() = TODO("Not yet implemented")
    override val nodes: Array<Indicator<*>>
        get() = TODO("Not yet implemented")

    override fun build(): SMAIndicator {
        TODO("Not yet implemented")
    }

    override fun isOver(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }
}