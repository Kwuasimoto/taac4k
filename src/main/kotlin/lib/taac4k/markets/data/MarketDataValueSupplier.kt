package lib.dank.markets.data

import lib.dank.analysis.ta.enums.OHLCV
import lib.dank.markets.data.MarketData
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
    val marketDataList: MutableList<MarketData>
    val barCount: Int

    fun beginTime(barIndex: Int): Long = marketDataList[barIndex].beginTime
    fun endTime(barIndex: Int): Long = marketDataList[barIndex].endTime
    fun timespan(barIndex: Int): String = marketDataList[barIndex].timespan

    fun barValue(
        marketSeries: MutableList<MarketData>,
        barIndex: Int,
        ohlc: OHLCV = OHLCV.CLOSE

    ): Double = marketSeries[barIndex].ohlcv[ohlc] as Double

    fun barValue(
        barIndex: Int,
        ohlc: OHLCV = OHLCV.CLOSE

    ): Double = marketDataList[barIndex].ohlcv[ohlc] as Double
}