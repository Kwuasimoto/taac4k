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
open class BarSeriesFactory(
    open val dateParser: MarketDateParser = BaseDateParser()
) {
    open fun fromJSON(string: String, name: String = "JSON_DEFAULT", builder: BaseBarSeriesBuilder? = null): BarSeries {
        val newSeries = builder?.build()
            ?: BaseBarSeriesBuilder().withName(name).withNumTypeOf(DecimalNum::class.java).build()

        for (jsonObject in JSONArray(string)) {
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