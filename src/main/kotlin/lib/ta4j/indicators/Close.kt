package lib.ta4j.indicators

import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import java.util.function.BooleanSupplier

class Close(
    val barSeries: BarSeries?
) : CloseBooleanProvider {

    override val indicator: ClosePriceIndicator
        get() =
            if (barSeries !== null)
                ClosePriceIndicator(barSeries)
            else throw Error("Close Price Indicator is null!")

    override fun isOver(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(barSeries: BarSeries, barIndex: Int): BooleanSupplier {
        TODO("Not yet implemented")
    }
}