package lib.taac4k.markets.data.factory

import lib.taac4k.analysis.ta.enums.OHLC
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDateParser

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

    override fun ticker(ticker: kotlin.String): MarketDataBuilder {
        marketDatum.ticker = ticker
        return this
    }

    override fun open(open: Double): MarketDataBuilder {
        marketDatum.ohlc[OHLC.OPEN] = open
        return this
    }

    override fun low(low: Double): MarketDataBuilder {
        marketDatum.ohlc[OHLC.LOW] = low
        return this
    }

    override fun high(high: Double): MarketDataBuilder {
        marketDatum.ohlc[OHLC.HIGH] = high
        return this
    }

    override fun close(close: Double): MarketDataBuilder {
        marketDatum.ohlc[OHLC.CLOSE] = close
        return this
    }

    override fun volume(volume: Double): MarketDataBuilder {
        marketDatum.volume = volume
        return this
    }

    override fun vwap(vwap: Double): MarketDataBuilder {
        marketDatum.vwap = vwap
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



