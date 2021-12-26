package lib.dank.markets.data.factory

import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.enums.TIMESPAN
import java.time.Duration
import java.time.ZonedDateTime

/**
 * Needs Builder
 */
class JSONMarketDataBuilder : MarketDataBuilder {
    private var marketDatum: JSONMarketData = JSONMarketData()

    override fun build(): JSONMarketData {
        val temp = marketDatum
        marketDatum = JSONMarketData()
        return temp
    }

    override fun ticker(ticker: String): MarketDataBuilder {
        marketDatum.ticker = ticker
        return this
    }

    override fun open(open: Double): MarketDataBuilder {
        marketDatum.open = open
        return this
    }

    override fun low(low: Double): MarketDataBuilder {
        marketDatum.low = low
        return this
    }

    override fun high(high: Double): MarketDataBuilder {
        marketDatum.high = high
        return this
    }

    override fun close(close: Double): MarketDataBuilder {
        marketDatum.close = close
        return this
    }

    override fun volume(volume: Double): MarketDataBuilder {
        marketDatum.volume = volume
        return this
    }

    override fun endTime(endTime: ZonedDateTime): MarketDataBuilder {
        marketDatum.endTime = endTime
        return this
    }

    override fun period(period: Duration): MarketDataBuilder {
        marketDatum.period = period
        return this
    }

    override fun vwap(vwap: Double): MarketDataBuilder {
        marketDatum.vwap = vwap
        return this
    }

    override fun beginTime(beginTime: Long): MarketDataBuilder {
        marketDatum.beginTime = beginTime
        return this
    }

    override fun timespan(timespan: TIMESPAN): MarketDataBuilder {
        marketDatum.timespan = timespan
        return this
    }

    override fun multiplier(multiplier: Long): MarketDataBuilder {
        marketDatum.multiplier = multiplier
        return this
    }
}



