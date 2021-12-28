package lib.taac4k.analysis.ta.ta4j

import lib.taac4k.analysis.ta.enums.OHLC
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.factory.MarketDateParser
import lib.taac4k.markets.data.enums.TIMESPAN
import lib.taac4k.markets.data.factory.DateParser
import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum

/**
 * Uses Builder
 */
open class BarSeriesFactory(
    open val dateParser: MarketDateParser = DateParser()
) {
    open fun fromMarketDataList(marketDataList: MutableList<MarketData>, name: String = "Factory Default"): BarSeries =
        if (marketDataList.size <= 0) throw IllegalArgumentException("marketDataJSONList is empty!, cant adapt")
        else {
            val barList = BaseBarSeriesBuilder()
                .withName(name)
                .withNumTypeOf(DecimalNum::class.java)
                .build()

            println("Can we get some data in the fucking console intellij?")
            for (marketData in marketDataList) {
                barList.addBar(
                    BaseBar(
                        dateParser.toDuration(TIMESPAN.valueOf(marketData.timespan), marketData.multiplier),
                        dateParser.toZonedDateTime(marketData.endTime),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.OPEN]),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.HIGH]),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.LOW]),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.CLOSE]),
                        DecimalNum.valueOf(marketData.volume),
                        DecimalNum.valueOf(marketData.vwap)
                    )
                )
            }

            barList
        }

    open fun fromJSON(json: String, name: String = "JSON_DEFAULT", builder: BaseBarSeriesBuilder? = null): BarSeries {
        val newSeries = builder?.build()
            ?: BaseBarSeriesBuilder().withName(name).withNumTypeOf(DecimalNum::class.java).build()

        for (jsonObject in JSONArray(json)) {
            jsonObject as JSONObject
            val ohlc = jsonObject.getJSONObject("ohlc")

            newSeries.addBar(
                BaseBar.builder()
                    .openPrice(DecimalNum.valueOf(ohlc.getDouble("OPEN")))
                    .highPrice(DecimalNum.valueOf(ohlc.getDouble("HIGH")))
                    .lowPrice(DecimalNum.valueOf(ohlc.getDouble("LOW")))
                    .closePrice(DecimalNum.valueOf(ohlc.getDouble("CLOSE")))
                    .amount(DecimalNum.valueOf(jsonObject.getDouble("vwap")))
                    .volume(DecimalNum.valueOf(jsonObject.getDouble("volume")))
                    .timePeriod(
                        dateParser.toDuration(
                            TIMESPAN.valueOf(jsonObject.getString("timespan")),
                            jsonObject.getLong("multiplier")
                        )
                    )
                    .endTime(dateParser.toZonedDateTime(jsonObject.getLong("endTime")))
                    .build()
            )
        }

        return newSeries
    }
}