package lib.dank.markets.io

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.ta4j.IndicatorBarFactory
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.data.factory.JSONMarketDataFactory
import org.json.JSONArray
import org.ta4j.core.BarSeries
import java.io.File
import java.util.*


/**
 * Utility Class, Optional use, it is not integrated forcefully anywhere.
 */
open class MarketDataIO(
    open val rawMutableMarketDataList: MutableList<JSONMarketData>? = null,

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

) : MarketAnalysisAdapter,          // For Getting Data to MutableList<MarketDataJSON>
    ResourceSupplier                // For Accessing Resources ez
{

    fun toBarSeries(name: String = "IO DEFAULT"): BarSeries =
        IndicatorBarFactory()
            .getBarSeriesFromJSON(
                getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)), name
            )


    fun read(aggregatesParams: AggregatesParameters? = null): MutableList<JSONMarketData> =
        if (aggregatesParams !== null) {

            JSONMarketDataFactory()
                .fromJSONArray(
                    JSONArray(
                        getJSONResourceAsString(
                            getJSONResourcePath(jsonFileName!!)
                        )
                    ),
                    aggregatesParameters = aggregatesParams
                )

        } else throw IllegalArgumentException("Could not parse JSON with supplied Params!")


    fun write(rawMutableMarketDataList: MutableList<JSONMarketData>? = this.rawMutableMarketDataList) =
        if (rawMutableMarketDataList !== null) // ...wha?
        {
            val data = rawMutableMarketDataList.toJSONArray()

            jsonFile.writer(Charsets.UTF_8).use {
                it.write(data.toString())
                true
            }
        } else throw IllegalArgumentException("Mutable Market Data List Null")

}

fun MutableList<JSONMarketData>.toJSONArray(): JSONArray {
    var out = ""

    for (datum in this) out +=
        """${if (indexOf(datum) == 0) "[" else ""} {
            "ticker":"${datum.ticker}",
            "open":"${datum.open}",
            "high":"${datum.high}",
            "low":"${datum.low}",
            "close":"${datum.close}",
            "volume":"${datum.volume}",
            "amount":"${datum.vwap}",
            "period":"${datum.period}",
            "beginTime":"${datum.beginTime}",
            "endTime":"${datum.endTime}",
            "multiplier":"${datum.multiplier}",
        }${if (this.size - 1 == indexOf(datum)) "]" else ","} 
        """.trimIndent().replace(" ", "")

    return JSONArray(out)
}



