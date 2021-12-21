package lib.ta4j.indicators

import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import java.util.function.BooleanSupplier

class Close(
    barSeries: BarSeries
) : CloseBooleanProvider {
    override val indicator: ClosePriceIndicator
        get() = TODO("Not yet implemented")
    override val nodes: Unit
        get() = TODO("Helper Indicators do not have nodes!")

    override fun build(): ClosePriceIndicator {
        TODO("Not yet implemented")
    }

    override fun isOver(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }
}