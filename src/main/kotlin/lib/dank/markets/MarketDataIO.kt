package lib.dank.markets

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.ta4j.TA4JBarFactory
import org.json.JSONArray
import org.json.JSONObject
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarBuilder
import org.ta4j.core.num.DecimalNum
import java.io.File
import java.time.ZonedDateTime
import java.util.*

class MarketDataIO(
    val rawMutableMarketDataList: MutableList<MarketDataJSON>? = null,

    val testResourcePath: String = "src/test/resources",
    val useTestResources: Boolean = true,
    val basePath: String =
        if (!useTestResources) "/json.market_data/"
        else "$testResourcePath/json.market_data/",

    val fileName: String? = null,
    val fileID: UUID = UUID.randomUUID(),
    val filePath: String = basePath +
            if (fileName !== null) fileName
            else "market_data_${fileID}.json",

    val file: File = File(filePath)

) : MarketAnalysisAdapter {

    fun toBarSeries(name: String = "Noice Default"): BarSeries {
        val resource = this::class.java.getResource("/json.market_data/$fileName")
            ?: throw IllegalArgumentException("Generic not recognized. Check Compatible TA Libraries [TA4J#BarSeries]")

        return TA4JBarFactory().fromJSON(String(resource.openStream().readAllBytes()))
    }

    fun write() =
        if (rawMutableMarketDataList !== null)
            file.writer(Charsets.UTF_8).use {
                it.write(rawMutableMarketDataList.toJSONArray().toString());
                true
            }
        else throw IllegalArgumentException("Mutable Market Data List Null")

}

fun MutableList<MarketDataJSON>.toJSONArray(): JSONArray {
    var out: String = ""

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
            "endTime":"${datum.endTime}"
        }${if (this.size - 1 == indexOf(datum)) "]" else ","} 
        """.trimIndent().replace(" ", "")

    return JSONArray(out)
}



