package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLCV

/**
 * ## MarketDataValues
 *
 * Provides concrete functions for getting values from a [MutableList]<[MarketData]>
 *
 * @param marketDataList the marketDataList to get values from
 */
class MarketDataValues(
    override val marketDataList: MutableList<MarketData>,
) : MarketDataValuesProvider {

    override fun beginTime(barIndex: Int): Long = marketDataList[barIndex].beginTime
    override fun endTime(barIndex: Int): Long = marketDataList[barIndex].endTime
    override fun timespan(barIndex: Int): String = marketDataList[barIndex].timespan
    override fun volume(barIndex: Int): Double = marketDataList[barIndex].volume

    override fun barValue(
        marketDataList: MutableList<MarketData>,
        barIndex: Int,
        ohlcv: OHLCV

    ): Double = marketDataList[barIndex].ohlcv[ohlcv] as Double

    override fun barValue(
        barIndex: Int,
        ohlcv: OHLCV

    ): Double = marketDataList[barIndex].ohlcv[ohlcv] as Double

    override fun highest(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Double {
        val barGapLength = rightBarIndex - leftBarIndex
        var highest = 0.00

        for (i in 0 until barGapLength) {
            val nextVal = barValue(leftBarIndex, leftBarOHLCV)
            // Start at leftBarIndex and iterate to rightBarIndex by Adding to i
            if (nextVal > highest) highest = nextVal
        }

        return highest
    }

    override fun lowest(leftBarIndex: Int, rightBarIndex: Int, leftBarOHLCV: OHLCV, rightBarOHLCV: OHLCV): Double {
        val barGapLength = rightBarIndex - leftBarIndex
        var lowest = 0.00

        for (i in 0 until barGapLength) {
            val nextVal = barValue(leftBarIndex, leftBarOHLCV)
            // Start at leftBarIndex and iterate to rightBarIndex by Adding to i
            if (nextVal < lowest) lowest = nextVal
        }

        return lowest
    }

}