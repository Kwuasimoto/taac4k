package lib.taac4k.markets.data.io

import lib.taac4k.markets.data.MarketData
import org.ta4j.core.BarSeries
import java.io.File

/**
 * IO Resource Provider
 * @version 0.0.1
 */
interface ResourceProvider : ResourceSupplier {
    /**
     * get a File
     */
    fun getFile(): File
    /**
     * get a File Path
     */
    fun getFilePath(): String
    /**
     * return IO Resource as a [BarSeries] for TA4J Indicators
     *
     * @param name the name to associate with the [BarSeries]
     * @return [BarSeries]
     */
    fun toBarSeries(name: String = "IO Default"): BarSeries
    /**
     * returns parsed JSON IO Resource
     * @return [MutableList]<[MarketData]>
     */
    fun readJSON(): MutableList<MarketData>
    /**
     * write a [MutableList]<[MarketData]> as a JSON File
     */
    fun writeJSON(inMarketDataList: MutableList<MarketData>? = null): Boolean
}