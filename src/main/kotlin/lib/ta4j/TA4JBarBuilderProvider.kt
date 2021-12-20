package lib.ta4j

import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarBuilder
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DoubleNum

abstract class TA4JBarBuilderProvider {
    protected val baseBarSeries: BaseBarSeriesBuilder
        get() = BaseBarSeriesBuilder()
            .withNumTypeOf(DoubleNum::valueOf)

    protected val barBuilder: BaseBarBuilder
        get() = BaseBar.builder(DoubleNum::valueOf, Number::class.java)

}