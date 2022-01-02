package lib.taac4k.analysis.ta.ta4j

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.enums.TIMESPAN
import lib.taac4k.markets.data.factory.BaseDateParser
import lib.taac4k.markets.data.factory.MarketDateParser
import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum

/**
 * ## BaseBarSeriesFactory
 * Class for providing oneshot methods for turning data from Type T to [BarSeries]
 *
 * @param dateParser [MarketDateParser]
 */
open class BarSeriesFactory(
    open val dateParser: MarketDateParser = BaseDateParser()
) {
    /**
     * ## fromMarketDataList
     * @param marketDataList list of Market Data
     * @param name name to give new BarSeries
     * @return [BarSeries]
     */
    open fun fromMarketDataList(marketDataList: MutableList<MarketData>, name: String = "Factory Default"): BarSeries =
        if (marketDataList.size <= 0) throw IllegalArgumentException("marketDataJSONList is empty!, cant adapt")
        else {
            val barList = BaseBarSeriesBuilder()
                .withName(name)
                .withNumTypeOf(DecimalNum::class.java)
                .build()

            for (marketData in marketDataList) {
                barList.addBar(
                    BaseBar(
                        dateParser.toDuration(TIMESPAN.valueOf(marketData.timespan), marketData.multiplier),
                        dateParser.toZonedDateTime(marketData.endTime),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.OPEN]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.HIGH]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.LOW]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.CLOSE]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.VWAP]),
                        DecimalNum.valueOf(marketData.volume)
                    )
                )
            }

            barList
        }
    /**
     * ## fromJSON
     * @param json the json of [MutableList]<[MarketData]> to convert to [BarSeries]
     * @param name name of the new BarSeries
     * @return [BarSeries]
     */
    open fun fromJSON(json: String, name: String = "JSON_DEFAULT"): BarSeries {
        val newSeries = BaseBarSeriesBuilder().build()
            ?: BaseBarSeriesBuilder().withName(name).withNumTypeOf(DecimalNum::class.java).build()

        for (jsonObject in JSONArray(json)) {
            jsonObject as JSONObject
            val ohlcv = jsonObject.getJSONObject("ohlcv")

            newSeries.addBar(
                BaseBar.builder()
                    .openPrice(DecimalNum.valueOf(ohlcv.getDouble(OHLCV.OPEN.name)))
                    .highPrice(DecimalNum.valueOf(ohlcv.getDouble(OHLCV.HIGH.name)))
                    .lowPrice(DecimalNum.valueOf(ohlcv.getDouble(OHLCV.LOW.name)))
                    .closePrice(DecimalNum.valueOf(ohlcv.getDouble(OHLCV.CLOSE.name)))
                    .amount(DecimalNum.valueOf(ohlcv.getDouble(OHLCV.VWAP.name)))
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