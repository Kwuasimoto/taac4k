package lib.taac4k.markets.data.factory

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataMutableListSupplier
import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import java.util.*

open class MarketDataFactory(
    open val builder: BaseMarketDataBuilder = MarketDataBuilder()
) : MarketDataMutableListSupplier {

    open fun fromBarSeries(barSeries: BarSeries): MutableList<MarketData> {
        val returnList = newList

        for(bar in barSeries.barData){
            returnList.add(builder
                .ticker(barSeries.name)
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
    open fun fromAggregates(aggregates: AggregatesDTO, aggregateParams: AggregatesParameters): MutableList<MarketData> {
        val returnList = newList

        for(dto in aggregates.results)
            returnList.add(builder
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
                .build())

        return returnList
    }

    open fun fromJSON(rawJson: String): MutableList<MarketData> {
        val returnList = newList

        for(jsonObject in JSONArray(rawJson)) {
            jsonObject as JSONObject
            val ohlcv = jsonObject.getJSONObject("ohlcv")

            returnList.add(
                builder
                    .ticker(jsonObject.getString("ticker"))
                    .open(ohlcv.getDouble(OHLCV.OPEN.name))
                    .high(ohlcv.getDouble(OHLCV.HIGH.name))
                    .low(ohlcv.getDouble(OHLCV.LOW.name))
                    .close(ohlcv.getDouble(OHLCV.CLOSE.name))
                    .vwap(ohlcv.getDouble(OHLCV.VWAP.name))
                    .volume(jsonObject.getDouble("volume"))
                    .endTime(jsonObject.getLong("endTime"))
                    .timespan(jsonObject.getString("timespan"))
                    .multiplier(jsonObject.getLong("multiplier"))
                    .build()
            )
        }

        return returnList
    }
}
