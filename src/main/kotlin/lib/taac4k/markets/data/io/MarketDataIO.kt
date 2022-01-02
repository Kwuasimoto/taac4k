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
 *
 * @param marketDataList the list of market data to write.
 * @param fileName the name of the json file to write data to.
 * @param testResourcePath path to test resources
 * @param useTestResources doing testing? check this to true.
 * @param basePath the path from resources to your json data file (ex: src/test/resources/json.market_Data/
 */
open class MarketDataIO(
    open val marketDataList: MutableList<MarketData> = mutableListOf(),
    open val fileName: String? = null,

    open val testResourcePath: String = "src/test/resources",
    open val useTestResources: Boolean = true,
    open val basePath: String =
        if (!useTestResources) "/json.market_data/"
        else "$testResourcePath/json.market_data/",

    ) : ResourceProvider {
    /**
     * ## GetFile
     * fetch the file specified by [getFilePath] return string
     * @return [File]
     */
    override fun getFile(): File =  File(getFilePath())
    /**
     * ## getFilePath
     * get the file path utilizing params provided in constructor.
     * @return String base path for resource file
     */
    override fun getFilePath(): String = basePath +
            if (fileName !== null) fileName
            else "market_data_${UUID.randomUUID()}.json"
    /**
     * ## ToBarSeries
     * Create a BarSeries object for TA4J Indicators from a MarketData JSON file.
     * @param name the name to give the new [BarSeries]
     * @return [BarSeries]
     */
    override fun toBarSeries(name: String): BarSeries = BarSeriesFactory()
        .fromJSON(getJSONResourceAsString(getJSONResourcePath(fileName!!)), name)
    /**
     * ## readJSON
     * Reads the underlying JSON Resource
     * @throws IOException
     * @return [MutableList]<[MarketData]>
     */
    override fun readJSON(): MutableList<MarketData> = MarketDataFactory()
        .fromJSON(getJSONResourceAsString(getJSONResourcePath(fileName!!)))
    /**
     * ## writeJSON
     * @param inMarketDataList the data to write to a JSON File
     * @throws IOException
     * @return [Boolean] whether the file was successfully written or not
     */
    override fun writeJSON(inMarketDataList: MutableList<MarketData>?): Boolean =
        getFile().writer(Charsets.UTF_8).use {
            it.write(JSONArray(inMarketDataList ?: marketDataList).toString())
            it.flush()
            it.close()
            true
        }
}

