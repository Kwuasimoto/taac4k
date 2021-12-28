package lib.taac4k.markets.data.factory

import lib.taac4k.markets.data.MarketData
import java.time.ZonedDateTime

interface BaseMarketDataBuilder {
    fun ticker(ticker: kotlin.String): BaseMarketDataBuilder
    fun open(open: Double): BaseMarketDataBuilder
    fun high(high: Double): BaseMarketDataBuilder
    fun low(low: Double): BaseMarketDataBuilder
    fun close(close: Double): BaseMarketDataBuilder
    fun volume(volume: Double): BaseMarketDataBuilder
    fun endTime(endTime: Long = ZonedDateTime.now().toEpochSecond()): BaseMarketDataBuilder
    fun vwap(vwap: Double): BaseMarketDataBuilder
    fun beginTime(beginTime: Long): BaseMarketDataBuilder
    fun timespan(timespan: String): BaseMarketDataBuilder
    fun multiplier(multiplier: Long): BaseMarketDataBuilder
    fun build(): MarketData
}