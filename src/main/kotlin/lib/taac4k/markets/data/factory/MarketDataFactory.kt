package lib.taac4k.markets.data.factory

import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.analysis.ta.enums.OHLC
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataListSupplier
import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import java.util.*

open class MarketDataFactory(
    open val builder: BaseMarketDataBuilder = MarketDataBuilder(),
    open val date: MarketDateParser = DateParser()
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


    open fun fromJSON(rawJson: String): MutableList<MarketData> {
        val returnList = newList

        for(jsonObject in JSONArray(rawJson)) {
            jsonObject as JSONObject
            val ohlc = jsonObject.getJSONObject("ohlc")

            returnList.add(
                builder
                    .ticker(jsonObject.getString("ticker"))
                    .open(ohlc.getDouble(OHLC.OPEN.name))
                    .high(ohlc.getDouble(OHLC.HIGH.name))
                    .low(ohlc.getDouble(OHLC.LOW.name))
                    .close(ohlc.getDouble(OHLC.CLOSE.name))
                    .volume(jsonObject.getDouble("volume"))
                    .vwap(jsonObject.getDouble("vwap"))
                    .endTime(jsonObject.getLong("endTime"))
                    .timespan(jsonObject.getString("timespan"))
                    .multiplier(jsonObject.getLong("multiplier"))
                    .build()
            )
        }

        return returnList
    }

}


//            returnList
//                .add(builder(jsonArray))