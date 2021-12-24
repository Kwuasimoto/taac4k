package lib.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.markets.MarketData

class PolygonMarketDataConverter(
    private val date: PolygonDateParser = PolygonDateParser()
) {
    fun transformAggregate(result: AggregateDTO, params: AggregatesParameters): MarketData
        = MarketData(
            result.ticker,
            result.open,
            result.high,
            result.low,
            result.close,
            result.volume,
            result.timestampMillis,
            date.parseMillis(result.timestampMillis),
            date.parseDuration(params.timespan, params.multiplier),
            result.volumeWeightedAveragePrice
        )
//    {
//        return barBuilder
//            .timePeriod()
//            .endTime()
//            .openPrice()
//            .highPrice(DoubleNum.valueOf(result.high))
//            .lowPrice(DoubleNum.valueOf(result.low))
//            .closePrice(DoubleNum.valueOf(result.close))
//            .volume(DoubleNum.valueOf(result.volume))
//            .build()
//    }
}