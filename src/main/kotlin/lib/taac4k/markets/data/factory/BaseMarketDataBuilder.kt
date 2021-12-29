package lib.taac4k.markets.data.factory

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData

/**
 * Needs Builder
 */
class BaseMarketDataBuilder(
    val date: MarketDateParser = BaseDateParser()
) : MarketDataBuilder {
    private var marketDatum: MarketData = MarketData()

    override fun build(): MarketData {
        val temp = marketDatum
        marketDatum = MarketData()
        return temp
    }

    override fun ticker(ticker: String): MarketDataBuilder {
        marketDatum.ticker = ticker
        return this
    }

    override fun open(open: Double): MarketDataBuilder {
        marketDatum.ohlcv[OHLCV.OPEN] = open
        return this
    }

    override fun low(low: Double): MarketDataBuilder {
        marketDatum.ohlcv[OHLCV.LOW] = low
        return this
    }

    override fun high(high: Double): MarketDataBuilder {
        marketDatum.ohlcv[OHLCV.HIGH] = high
        return this
    }

    override fun close(close: Double): MarketDataBuilder {
        marketDatum.ohlcv[OHLCV.CLOSE] = close
        return this
    }

    override fun volume(volume: Double): MarketDataBuilder {
        marketDatum.volume = volume
        return this
    }

    override fun vwap(vwap: Double): MarketDataBuilder {
        marketDatum.ohlcv[OHLCV.VWAP] = vwap
        return this
    }

    override fun endTime(endTime: Long): MarketDataBuilder {
        marketDatum.endTime = endTime
        return this
    }

    override fun beginTime(beginTime: Long): MarketDataBuilder {
        marketDatum.beginTime = beginTime
        return this
    }

    override fun timespan(timespan: String): MarketDataBuilder {
        marketDatum.timespan = timespan
        return this
    }

    override fun multiplier(multiplier: Long): MarketDataBuilder {
        marketDatum.multiplier = multiplier
        return this
    }
}



