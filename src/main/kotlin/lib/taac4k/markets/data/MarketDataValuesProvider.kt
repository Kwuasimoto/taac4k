package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLCV

/**
 * Interface for helping provide data values from specified indices in a MutableList<MarketData>
 * @version 0.0.1
 */
interface MarketDataValuesProvider {
    /**
     * The datalist to get values from
     */
    val marketDataList: MutableList<MarketData>
    /**
     * better variable for assisting in writing conditions
     */
    val barCount: Int get() = marketDataList.size
    /**
     * @param barIndex get begin time of bar at index [barIndex]
     * @return [Long] begin time in epoch seconds
     */
    fun beginTime(barIndex: Int): Long
    /**
     * @param barIndex get end time of bar at index [barIndex]
     * @return [Long] end time in epoch seconds
     */
    fun endTime(barIndex: Int): Long
    /**
     * @param barIndex get timespan of bar at index [barIndex]
     * @return [String] get the timespan of the bar
     */
    fun timespan(barIndex: Int): String
    /**
     * @param barIndex get volume of bar at index [barIndex]
     * @return [Double] volume value of the bar
     */
    fun volume(barIndex: Int): Double
    /**
     * @param marketDataList in-data for getting a ohlcv value from.
     * @param barIndex get an [ohlcv] value of bar at index [barIndex]
     * @param ohlcv select which part of a bar of data to use to determine a condition.
     * @return [Double] the open | high | low | close | vwap value indexed
     */
    fun barValue(
        marketDataList: MutableList<MarketData>,
        barIndex: Int,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Double
    /**
     * @param barIndex the [OHLCV] value of bar at index [barIndex]
     * @param ohlcv select which part of a bar of data to use to determine a condition.
     * @return [Double] the open | high | low | close | vwap value indexed
     */
    fun barValue(
        barIndex: Int,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Double
    /**
     * Gets the highest value in range [rightBarIndex] - [leftBarIndex]
     *
     * @param leftBarIndex the bar to start scanning right from
     * @param rightBarIndex the bar to stop scanning at
     * @param leftBarOHLCV select which part of a bar of data to use to determine a condition.
     * @param rightBarOHLCV select which part of a bar of data to use to determine a condition.
     * @return [Double] the highest value in the specified range
     */
    fun highest(
        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE
    ): Double
    /**
     * Gets the lowest value in range [rightBarIndex] - [leftBarIndex]
     *
     * @param leftBarIndex the bar to start scanning right from
     * @param rightBarIndex the bar to stop scanning at
     * @param leftBarOHLCV select which part of a bar of data to use to determine a condition.
     * @param rightBarOHLCV select which part of a bar of data to use to determine a condition.
     * @return [Double] the lowest value in the specified range
     */
    fun lowest(
        leftBarIndex: Int,
        rightBarIndex: Int,

        leftBarOHLCV: OHLCV = OHLCV.CLOSE,
        rightBarOHLCV: OHLCV = OHLCV.CLOSE
    ): Double

}