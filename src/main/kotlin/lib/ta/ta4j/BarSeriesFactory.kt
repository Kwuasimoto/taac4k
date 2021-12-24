package lib.ta.ta4j

import org.ta4j.core.Bar
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeriesBuilder

class BarSeriesFactory {
    fun barSeries(name: String = "Lunos"): BarSeries =
        BaseBarSeriesBuilder()
            .withName(name)
            .build()

    fun barSeriesFromData(bars: MutableList<Bar>, name: String = "Lunos"): BarSeries =
        BaseBarSeriesBuilder()
            .withBars(bars).withName(name)
            .build()
}