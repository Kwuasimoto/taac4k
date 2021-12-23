package lib.ta4j.suppliers

import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarBuilder
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DoubleNum

/**
 * ## TA4JBarBuilder
 */
interface BarBuilderSupplier {    /**
     * I think default implementation here is acceptable
     * Can still be overriden by implemention
     */
    val baseBarSeries: BaseBarSeriesBuilder
        get() =
            BaseBarSeriesBuilder()
            .withNumTypeOf(DoubleNum::valueOf)

    val barBuilder: BaseBarBuilder
        get() =
            BaseBar
            .builder(DoubleNum::valueOf, Number::class.java)
}

