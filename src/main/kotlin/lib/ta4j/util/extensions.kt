package lib.ta4j.util

import org.ta4j.core.BarSeries

fun BarSeries.isOver(barSeries: BarSeries, barIndex: Int = 0) =
    this.getBar(barIndex).closePrice > barSeries.getBar(barIndex).closePrice

