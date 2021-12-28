package lib.taac4k.analysis.ta.ta4j

import lib.taac4k.markets.data.MarketDateParser
import lib.taac4k.markets.data.enums.TIMESPAN
import lib.taac4k.markets.data.factory.BaseDateParser
import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum

/**
 * Uses Builder
 */
open class IndicatorBarSeriesFactory(
    open val dateParser: MarketDateParser = BaseDateParser()
) {
    open fun fromJSON(string: String, name: String = "JSON_DEFAULT", builder: BaseBarSeriesBuilder? = null): BarSeries {
        val newSeries = builder?.build()
            ?: BaseBarSeriesBuilder().withName(name).withNumTypeOf(DecimalNum::class.java).build()

        for (jsonObject in JSONArray(string)) {
            jsonObject as JSONObject
            val ohlcv = jsonObject.getJSONObject("ohlcv")

            newSeries.addBar(
                BaseBar.builder()
                    .openPrice(DecimalNum.valueOf(ohlcv["OPEN"].toString().toDouble()))
                    .highPrice(DecimalNum.valueOf(ohlcv["HIGH"].toString().toDouble()))
                    .lowPrice(DecimalNum.valueOf(ohlcv["LOW"].toString().toDouble()))
                    .closePrice(DecimalNum.valueOf(ohlcv["CLOSE"].toString().toDouble()))
                    .amount(DecimalNum.valueOf(ohlcv["VWAP"].toString().toDouble()))
                    .volume(DecimalNum.valueOf(ohlcv["VOLUME"].toString().toDouble()))
                    .timePeriod(
                        dateParser.toDuration(
                            TIMESPAN.valueOf(jsonObject["timespan"].toString()),
                            jsonObject["multiplier"].toString().toLong()
                        )
                    )
                    .endTime(dateParser.toZonedDateTime(jsonObject["endTime"].toString().toLong()))
                    .build()
            )
        }

        return newSeries
    }
}