package lib.taac4k.markets.data.io

import lib.taac4k.analysis.ta.ta4j.BarSeriesFactory
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.factory.BaseMarketDataFactory
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

) : BaseMarketDataAdapter, ResourceSupplier {

    fun toBarSeries(name: String = "IO DEFAULT"): BarSeries = BarSeriesFactory()
        .fromJSON(getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)), name)


    fun read(): MutableList<MarketData> = BaseMarketDataFactory()
        .fromJSON(getJSONResourceAsString(getJSONResourcePath(jsonFileName!!)))


    fun write(rawMutableMarketDataList: MutableList<MarketData> = marketDataList): Boolean =
        jsonFile.writer(Charsets.UTF_8).use {
            it.write(JSONArray(rawMutableMarketDataList).toString())
            it.flush()
            it.close()
            true
        }
}

