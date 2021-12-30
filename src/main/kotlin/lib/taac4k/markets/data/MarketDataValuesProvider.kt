package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLCV

/**
 * Interface for helping provide data values from indices in a MutableList<MarketData>
 * @version 0.0.1
 */
interface MarketDataValuesProvider {
    val marketDataList: MutableList<MarketData>
    val barCount: Int get() = marketDataList.size

    fun beginTime(barIndex: Int): Long
    fun endTime(barIndex: Int): Long
    fun timespan(barIndex: Int): String

    fun volume(barIndex: Int): Double

    fun barValue(
        marketSeries: MutableList<MarketData>,
        barIndex: Int,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Double

    fun barValue(
        barIndex: Int,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Double

    fun highest(
        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE
    ): Double

    fun lowest(
        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE
    ): Double

}