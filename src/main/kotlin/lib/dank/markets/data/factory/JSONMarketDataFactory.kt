package lib.dank.markets.data.factory

import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.data.MarketDateParser
import lib.dank.markets.enums.TIMESPAN
import lib.dank.markets.polygon.PolygonDateParser
import lib.dank.markets.suppliers.MarketDataJSONListSupplier
import org.json.JSONArray
import org.json.JSONObject
import java.time.Duration
import java.time.ZonedDateTime
import java.util.*

open class JSONMarketDataFactory(
    open val builder: JSONMarketDataBuilder = JSONMarketDataBuilder(),
    open val date: MarketDateParser = PolygonDateParser()
    ) : MarketDataJSONListSupplier {

    /**
     * @DATALOSS - beginTime
     */
    open fun fromAggregate(dto: AggregateDTO, aggregateParams: AggregatesParameters): JSONMarketData =
        builder
            .ticker(aggregateParams.ticker)
            .open(dto.open!!)
            .high(dto.high!!)
            .low(dto.low!!)
            .close(dto.close!!)
            .volume(dto.volume!!)
            .vwap(dto.volumeWeightedAveragePrice!!)

            .period(
                date.parseDuration(
                    TIMESPAN.valueOf(aggregateParams.timespan.uppercase(Locale.getDefault())),
                    aggregateParams.multiplier
                )
            )
            .endTime(date.parseMillis(dto.timestampMillis))
            .timespan(TIMESPAN.valueOf(aggregateParams.timespan.uppercase(Locale.getDefault())))
            .multiplier(aggregateParams.multiplier)

            .build()


    open fun fromJSONArray(
        jsonArray: JSONArray,
        aggregatesParameters: AggregatesParameters? = null,
        date: MarketDateParser = PolygonDateParser()
    ): MutableList<JSONMarketData> =
        if(aggregatesParameters !== null){

            val returnList = newList

            for (rawJSON in jsonArray) {

                rawJSON as JSONObject

                println(rawJSON)
                returnList.add(builder

                    .ticker(rawJSON["ticker"].toString())
                    .open(rawJSON["open"].toString().toDouble())
                    .high(rawJSON["high"].toString().toDouble())
                    .low(rawJSON["low"].toString().toDouble())
                    .close(rawJSON["close"].toString().toDouble())
                    .volume(rawJSON["volume"].toString().toDouble())
                    .vwap(rawJSON["amount"].toString().toDouble())

                    .beginTime(rawJSON["beginTime"].toString().toLong())
                    .endTime(ZonedDateTime.parse(rawJSON["endTime"].toString()))
                    .period(Duration.parse(rawJSON["period"].toString()))
                    .multiplier(rawJSON["multiplier"].toString().toLong())

                    .build())
            }

            returnList

        } else throw IllegalArgumentException("Could not cast JSON Data to JSONArray [Factory]")

}


//            returnList
//                .add(builder(jsonArray))