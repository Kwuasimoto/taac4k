package lib.taac4k.markets.data.factory

import lib.taac4k.markets.data.MarketData
import java.time.ZonedDateTime

interface MarketDataBuilder {
    fun ticker(ticker: kotlin.String): MarketDataBuilder
    fun open(open: Double): MarketDataBuilder
    fun high(high: Double): MarketDataBuilder
    fun low(low: Double): MarketDataBuilder
    fun close(close: Double): MarketDataBuilder
    fun volume(volume: Double): MarketDataBuilder
    fun endTime(endTime: Long = ZonedDateTime.now().toEpochSecond()): MarketDataBuilder
    fun vwap(vwap: Double): MarketDataBuilder
    fun beginTime(beginTime: Long): MarketDataBuilder
    fun timespan(timespan: String): MarketDataBuilder
    fun multiplier(multiplier: Long): MarketDataBuilder
    fun build(): MarketData
}