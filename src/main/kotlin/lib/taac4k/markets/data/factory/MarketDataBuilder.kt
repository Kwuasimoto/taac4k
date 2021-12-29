package lib.taac4k.markets.data.factory

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData

/**
 * Needs Builder
 */
class MarketDataBuilder(
    val date: MarketDateParser = DateParser()
) : BaseMarketDataBuilder {
    private var marketDatum: MarketData = MarketData()

    override fun build(): MarketData {
        val temp = marketDatum
        marketDatum = MarketData()
        return temp
    }

    override fun ticker(ticker: kotlin.String): BaseMarketDataBuilder {
        marketDatum.ticker = ticker
        return this
    }

    override fun open(open: Double): BaseMarketDataBuilder {
        marketDatum.ohlcv[OHLCV.OPEN] = open
        return this
    }

    override fun low(low: Double): BaseMarketDataBuilder {
        marketDatum.ohlcv[OHLCV.LOW] = low
        return this
    }

    override fun high(high: Double): BaseMarketDataBuilder {
        marketDatum.ohlcv[OHLCV.HIGH] = high
        return this
    }

    override fun close(close: Double): BaseMarketDataBuilder {
        marketDatum.ohlcv[OHLCV.CLOSE] = close
        return this
    }

    override fun volume(volume: Double): BaseMarketDataBuilder {
        marketDatum.volume = volume
        return this
    }

    override fun vwap(vwap: Double): BaseMarketDataBuilder {
        marketDatum.ohlcv[OHLCV.VWAP] = vwap
        return this
    }

    override fun endTime(endTime: Long): BaseMarketDataBuilder {
        marketDatum.endTime = endTime
        return this
    }

    override fun beginTime(beginTime: Long): BaseMarketDataBuilder {
        marketDatum.beginTime = beginTime
        return this
    }

    override fun timespan(timespan: String): BaseMarketDataBuilder {
        marketDatum.timespan = timespan
        return this
    }

    override fun multiplier(multiplier: Long): BaseMarketDataBuilder {
        marketDatum.multiplier = multiplier
        return this
    }
}



