package lib.taac4k.markets.data.io

import lib.taac4k.analysis.ta.ta4j.BarSeriesFactory
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.factory.MarketDataFactory
import org.json.JSONArray
import org.ta4j.core.BarSeries
import java.io.File
import java.util.*

/**
 * Utility Class, Optional use, it is not integrated forcefully anywhere.
 */
open class MarketDataIO(
    open val marketDataList: MutableList<MarketData> = mutableListOf(),
    open val jsonFileName: String? = null,

    open val testResourcePath: String = "src/test/resources",
    open val useTestResources: Boolean = true,
    open val basePath: String =
        if (!useTestResources) "/json.market_data/"
        else "$testResourcePath/json.market_data/",

) : ResourceProvider {

    override fun getFile(): File =  File(getFilePath())
    override fun getFilePath(): String = basePath +
            if (jsonFileName !== null) jsonFileName
            else "market_data_${UUID.randomUUID()}.json"


    override fun toBarSeries(name: String): BarSeries = BarSeriesFactory()
        .fromJSON(getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)), name)

    override fun read(): MutableList<MarketData> = MarketDataFactory()
        .fromJSON(getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)))

    override fun write(inMarketDataList: MutableList<MarketData>?): Boolean =
        getFile().writer(Charsets.UTF_8).use {
            it.write(JSONArray(inMarketDataList ?: marketDataList).toString())
            it.flush()
            it.close()
            true
        }
}

