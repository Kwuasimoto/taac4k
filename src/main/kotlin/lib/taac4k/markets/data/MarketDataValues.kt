package lib.taac4k.markets.data

import lib.taac4k.analysis.ta.enums.OHLCV

class MarketDataValues(
    override val marketDataList: MutableList<MarketData>

) : MarketDataValuesProvider {

    override fun beginTime(barIndex: Int): Long = marketDataList[barIndex].beginTime
    override fun endTime(barIndex: Int): Long = marketDataList[barIndex].endTime
    override fun timespan(barIndex: Int): String = marketDataList[barIndex].timespan

    override fun volume(barIndex: Int): Double = marketDataList[barIndex].volume

    override fun barValue(
        marketSeries: MutableList<MarketData>,
        barIndex: Int,
        ohlcv: OHLCV

    ): Double = marketSeries[barIndex].ohlcv[ohlcv] as Double

    override fun barValue(
        barIndex: Int,
        ohlcv: OHLCV

    ): Double = marketDataList[barIndex].ohlcv[ohlcv] as Double

}