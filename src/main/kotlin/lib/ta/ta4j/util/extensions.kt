package lib.ta.ta4j

import org.ta4j.core.BarSeries

fun BarSeries.isRising(length: Int) =
    if(length > 0) {
        var result = true

        for (i in 0 until length) {
            if(!result) break
            if(i == 0) continue;

            result = getBar(barCount - i).closePrice >
                        getBar(barCount - (i + 1)).closePrice
        }

        result
    }
    else getBar(barCount - 1).closePrice >
            getBar(barCount - 2).closePrice
