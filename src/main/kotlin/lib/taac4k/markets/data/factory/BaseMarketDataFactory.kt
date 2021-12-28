package lib.dank.markets.data.factory

import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.MarketDataBuilder
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.MarketDateParser
import lib.dank.markets.data.MarketDataListSupplier
import org.json.JSONArray
import org.ta4j.core.BarSeries
import java.util.*

open class BaseMarketDataFactory(
    open val builder: MarketDataBuilder = BaseMarketDataBuilder(),
    open val date: MarketDateParser = BaseDateParser()
    ) : MarketDataListSupplier {

    open fun fromBarSeries(barSeries: BarSeries): MutableList<MarketData> {
        val returnList = newList

        for(bar in barSeries.barData){
            returnList.add(builder
                .ticker(barSeries.name) // ?
                .open(bar.openPrice.doubleValue())
                .high(bar.highPrice.doubleValue())
                .low(bar.lowPrice.doubleValue())
                .close(bar.closePrice.doubleValue())
                .volume(bar.volume.doubleValue())
                .vwap(bar.volume.doubleValue()) // Need a vwap supplier,
                .beginTime(bar.beginTime.toEpochSecond())
                .endTime(bar.endTime.toEpochSecond())
                .build())
        }

        return returnList
    }

    /**
     * @DATALOSS - beginTime
     */
    open fun fromAggregate(dto: AggregateDTO, aggregateParams: AggregatesParameters): MarketData =
        builder
            .ticker(aggregateParams.ticker)
            .open(dto.open!!)
            .high(dto.high!!)
            .low(dto.low!!)
            .close(dto.close!!)
            .volume(dto.volume!!)
            .vwap(dto.volumeWeightedAveragePrice!!)
            .endTime(dto.timestampMillis!!)
            .timespan(aggregateParams.timespan.uppercase(Locale.getDefault()))
            .multiplier(aggregateParams.multiplier)
            .build()


    open fun fromJSON(
        rawJson: String,
        aggregatesParameters: AggregatesParameters? = null,
        date: MarketDateParser = BaseDateParser()
    ): MutableList<MarketData> =
        if(aggregatesParameters !== null){

//            val returnList = newList
//
//            for (rawJSON in ) {
//                rawJSON as JSONObject
//
//                returnList.add(builder
//                    .ticker(rawJSON["ticker"].toString())
//                    .open(rawJSON["open"].toString().toDouble())
//                    .high(rawJSON["high"].toString().toDouble())
//                    .low(rawJSON["low"].toString().toDouble())
//                    .close(rawJSON["close"].toString().toDouble())
//                    .volume(rawJSON["volume"].toString().toDouble())
//                    .vwap(rawJSON["vwap"].toString().toDouble())
//                    .beginTime(rawJSON["beginTime"].toString().toLong())
//                    .endTime(rawJSON["endTime"].toString().toLong())
//                    .period(rawJSON["period"].toString())
//                    .multiplier(rawJSON["multiplier"].toString().toLong())
//
//                    .build())
//            }
            val json = JSONArray(rawJson)

            json.toMutableList() as MutableList<MarketData>

        } else throw IllegalArgumentException("Could not cast JSON Data to JSONArray [Factory]")

}


//            returnList
//                .add(builder(jsonArray))