package lib.dank.markets.data.factory

import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.enums.TIMESPAN
import java.time.Duration
import java.time.ZonedDateTime

interface MarketDataBuilder {
    fun ticker(ticker:String): MarketDataBuilder
    fun open(open:Double): MarketDataBuilder
    fun high(high:Double): MarketDataBuilder
    fun low(low:Double): MarketDataBuilder
    fun close(close:Double): MarketDataBuilder
    fun volume(volume:Double): MarketDataBuilder
    fun endTime(endTime:ZonedDateTime = ZonedDateTime.now()): MarketDataBuilder
    fun period(period: Duration): MarketDataBuilder
    fun vwap(vwap:Double): MarketDataBuilder
    fun beginTime(beginTime: Long): MarketDataBuilder
    fun timespan(timespan: TIMESPAN): MarketDataBuilder
    fun multiplier(multiplier: Long): MarketDataBuilder
    fun build(): JSONMarketData
}