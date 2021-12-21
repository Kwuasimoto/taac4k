package lib.ta4j

import lib.ta4j.indicators.MACD
import lib.ta4j.indicators.MACDBooleanProvider
import lib.ta4j.util.MovingAverageConditions
import lib.ta4j.util.isOver
import org.ta4j.core.BarSeries
import org.ta4j.core.indicators.MACDIndicator
import org.ta4j.core.indicators.SMAIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.num.DoubleNum
import org.ta4j.core.num.Num
import java.util.function.BooleanSupplier

interface ITA4JBooleanProvider {
    val macd: MACDBooleanProvider
    val rsi: String /* NOT IMPLEMENTED */
}

open class TA4JBooleanProvider(
    override val macd: MACD = MACD(),
    override val rsi: String = ""
    /**
     * Supply indicators
     */
): ITA4JBooleanProvider {
    fun macd(
        barSeries: BarSeries,
        condition: MovingAverageConditions,

        value: Num = DoubleNum.valueOf(0),
        barIndex: Int = 0,

        shortTimeFrame: Int = 13,
        longTimeFrame: Int = 26,
        smaLength: Int = 9,
    ): BooleanSupplier {

        val macdIndicator = MACDIndicator(
            SMAIndicator(ClosePriceIndicator(barSeries), smaLength),
            shortTimeFrame,
            longTimeFrame
        )

        val longTerm = macdIndicator.longTermEma.barSeries
        val shortTerm = macdIndicator.shortTermEma.barSeries


        return when (condition) {
            MovingAverageConditions.OVER -> BooleanSupplier {
                shortTerm.isOver(longTerm, barIndex)
            }

            MovingAverageConditions.UNDER -> BooleanSupplier {
                !shortTerm.isOver(longTerm, barIndex)
            }
        }
    }
}




