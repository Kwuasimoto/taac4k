package lib.dank.markets.suppliers

import lib.dank.analysis.ta.enums.OHLC
import lib.dank.markets.data.JSONMarketData
import java.time.Duration
import java.time.ZonedDateTime

//
//import org.ta4j.core.Bar
//import org.ta4j.core.Indicator
//import org.ta4j.core.num.Num
//import java.time.ZonedDateTime
//
///**
// * Never instantiated.
// */
//abstract class IndicatorBarValueSupplier(private val indicator: Indicator<*>) {
//
//    val barCount: Int = indicator.barSeries.barCount
//
//    private fun barAt(barIndex: Int): Bar = indicator.barSeries.getBar(barIndex)
//
//    fun openPrice(barIndex: Int): Num = barAt(barIndex).openPrice
//    fun close(barIndex: Int): Num = barAt(barIndex).closePrice
//    fun highPrice(barIndex: Int): Num = barAt(barIndex).highPrice
//    fun lowPrice(barIndex: Int): Num = barAt(barIndex).lowPrice
//
//    fun amount(barIndex: Int): Num = barAt(barIndex).amount
//    fun volume(barIndex: Int): Num = barAt(barIndex).volume
//
//    fun beginTime(barIndex: Int): ZonedDateTime = barAt(barIndex).beginTime
//    fun dateName(barIndex: Int): String = barAt(barIndex).dateName
//    fun endTime(barIndex: Int): ZonedDateTime = barAt(barIndex).endTime
//}

interface MarketDataValueSupplier {
    val marketDataList: MutableList<JSONMarketData>
    val barCount: Int

    fun barValue(marketSeries: MutableList<JSONMarketData>, barIndex: Int, ohlc: OHLC = OHLC.CLOSE): Double =
        marketSeries[barIndex][ohlc.name] as Double

    fun barValue(barIndex: Int, ohlc: OHLC = OHLC.CLOSE): Double = marketDataList[barIndex][ohlc.name] as Double

    fun volume(barIndex: Int, ohlc: OHLC = OHLC.CLOSE): Double = marketDataList[barIndex].volume

    fun beginTime(barIndex: Int): Long = marketDataList[barIndex].beginTime
    fun duration(barIndex: Int): Duration = marketDataList[barIndex].period
    fun endTime(barIndex: Int): ZonedDateTime = marketDataList[barIndex].endTime
}