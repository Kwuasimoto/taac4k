package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLC

/**
 * *Assistant* interface for ConditionsProvider,
 * makes getting bar values from a MarketDataList easier.
 */
interface MarketDataValuesProvider {
    val marketDataList: MutableList<MarketData>
    val barCount: Int get() = marketDataList.size

    fun beginTime(barIndex: Int): Long
    fun endTime(barIndex: Int): Long
    fun timespan(barIndex: Int): String

    fun volume(barIndex: Int): Double
    fun vwap(barIndex: Int): Double

    fun barValue(
        marketSeries: MutableList<MarketData>,
        barIndex: Int,
        ohlc: OHLC = OHLC.CLOSE

    ): Double

    fun barValue(
        barIndex: Int,
        ohlc: OHLC = OHLC.CLOSE

    ): Double

}