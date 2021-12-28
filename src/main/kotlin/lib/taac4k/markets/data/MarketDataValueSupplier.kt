package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLC

/**
 * *Assistant* interface for ConditionsProvider,
 * makes getting bar values from a MarketDataList easier.
 */
interface MarketDataValueSupplier {
    val marketDataList: MutableList<MarketData>
    val barCount: Int

    fun beginTime(barIndex: Int): Long = marketDataList[barIndex].beginTime
    fun endTime(barIndex: Int): Long = marketDataList[barIndex].endTime
    fun timespan(barIndex: Int): String = marketDataList[barIndex].timespan

    fun volume(barIndex: Int): Double = marketDataList[barIndex].volume
    fun vwap(barIndex: Int): Double = marketDataList[barIndex].vwap

    fun barValue(
        marketSeries: MutableList<MarketData>,
        barIndex: Int,
        ohlc: OHLC = OHLC.CLOSE

    ): Double = marketSeries[barIndex].ohlc[ohlc] as Double

    fun barValue(
        barIndex: Int,
        ohlc: OHLC = OHLC.CLOSE

    ): Double = marketDataList[barIndex].ohlc[ohlc] as Double
}