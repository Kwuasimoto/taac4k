package lib.taac4k.markets.data.io

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.analysis.ta.ta4j.IndicatorBarSeriesFactory
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.factory.BaseMarketDataFactory
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.json.JSONArray
import org.ta4j.core.BarSeries
import java.io.File
import java.util.*


/**
 * Utility Class, Optional use, it is not integrated forcefully anywhere.
 */
open class MarketDataIO(
    open val marketDataList: MutableList<MarketData> = mutableListOf(),

    open val testResourcePath: String = "src/test/resources",
    open val useTestResources: Boolean = true,
    open val basePath: String =
        if (!useTestResources) "/json.market_data/"
        else "$testResourcePath/json.market_data/",

    open val jsonFileName: String? = null,
    open val jsonFileID: UUID = UUID.randomUUID(),
    open val jsonFilePath: String = basePath +
            if (jsonFileName !== null) jsonFileName
            else "market_data_${jsonFileID}.json",

    open val jsonFile: File = File(jsonFilePath)

) : MarketDataAdapter,          // For Getting Data to MutableList<MarketDataJSON>
    ResourceSupplier                // For Accessing Resources ez
{

    fun toBarSeries(name: String = "IO DEFAULT"): BarSeries =
        IndicatorBarSeriesFactory()
            .fromJSON(
                getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)), name
            )


    fun read(aggregatesParams: AggregatesParameters): MutableList<MarketData> =
        BaseMarketDataFactory()
            .fromJSON(
                getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)),
                aggregatesParameters = aggregatesParams
            )


    fun write(rawMutableMarketDataList: MutableList<MarketData> = marketDataList): Boolean {
        val json = JSONArray(rawMutableMarketDataList).toString()

        jsonFile.writer(Charsets.UTF_8).use {
            it.write(json)
            it.flush()
            it.close()
        }
        return true
    }
}
//
//fun MutableList<MarketData>.toJSONArray(): JSONArray {
//    var out = ""
//
//    for (datum in this) out +=
//        """${if (indexOf(datum) == 0) "[" else ""} {
//            "ticker":"${datum.ticker}",
//            "open":"${datum.ohlcv[OHLCV.OPEN]}",
//            "high":"${datum.ohlcv[OHLCV.HIGH]}",
//            "low":"${datum.ohlcv[OHLCV.LOW]}",
//            "close":"${datum.ohlcv[OHLCV.CLOSE]}",
//            "volume":"${datum.ohlcv[OHLCV.VOLUME]}",
//            "vwap":"${datum.ohlcv[OHLCV.VWAP]}",
//            "period":"${datum.period}",
//            "beginTime":"${datum.beginTime}",
//            "endTime":"${datum.endTime}",
//            "multiplier":"${datum.multiplier}",
//        }${if (this.size - 1 == indexOf(datum)) "]" else ","}
//        """.trimIndent().replace(" ", "")
//
//    return JSONArray(this)
//}



