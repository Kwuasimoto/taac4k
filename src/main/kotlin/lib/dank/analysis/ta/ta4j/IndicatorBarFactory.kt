package lib.dank.analysis.ta.ta4j

import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum
import java.time.Duration
import java.time.ZonedDateTime

/**
 * Uses Builder
 */
open class IndicatorBarFactory  {
    open fun getBarSeriesFromJSON(string: String, name: String = "JSON_DEFAULT", builder: BaseBarSeriesBuilder? = null): BarSeries {
        val newSeries = builder?.build()
            ?: BaseBarSeriesBuilder().withName(name).withNumTypeOf(DecimalNum::class.java).build()

        for (jsonObject in JSONArray(string)) {
            jsonObject as JSONObject
            newSeries.addBar(
                BaseBar.builder()
                    .openPrice(DecimalNum.valueOf(jsonObject["open"].toString().toDouble()))
                    .highPrice(DecimalNum.valueOf(jsonObject["high"].toString().toDouble()))
                    .lowPrice(DecimalNum.valueOf(jsonObject["low"].toString().toDouble()))
                    .closePrice(DecimalNum.valueOf(jsonObject["close"].toString().toDouble()))
                    .amount(DecimalNum.valueOf(jsonObject["amount"].toString().toDouble()))
                    .volume(DecimalNum.valueOf(jsonObject["volume"].toString().toDouble()))
                    .timePeriod(Duration.parse(jsonObject["period"].toString()))
                    .endTime(ZonedDateTime.parse(jsonObject["endTime"].toString()))
                    .build()
            )
        }

        return newSeries
    }
}