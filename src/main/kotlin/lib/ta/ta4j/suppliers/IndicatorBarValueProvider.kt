package lib.ta.ta4j.suppliers

import org.ta4j.core.Bar
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num
import java.time.ZonedDateTime

abstract class IndicatorBarValueProvider(private val indicator: Indicator<*>) {

    val barCount:Int = indicator.barSeries.barCount

    private fun barAt(barIndex: Int): Bar = indicator.barSeries.getBar(barIndex)

    fun openPrice(barIndex: Int): Num = barAt(barIndex).openPrice
    fun close(barIndex: Int): Num = barAt(barIndex).closePrice
    fun highPrice(barIndex: Int): Num = barAt(barIndex).highPrice
    fun lowPrice(barIndex: Int): Num = barAt(barIndex).lowPrice

    fun amount(barIndex: Int): Num = barAt(barIndex).amount
    fun volume(barIndex: Int): Num = barAt(barIndex).volume

    fun beginTime(barIndex: Int): ZonedDateTime = barAt(barIndex).beginTime
    fun dateName(barIndex: Int): String = barAt(barIndex).dateName
    fun endTime(barIndex: Int): ZonedDateTime = barAt(barIndex).endTime
}