package lib.taac4k.markets.data.io

import lib.taac4k.markets.data.MarketData
import org.ta4j.core.BarSeries
import java.io.File

interface ResourceProvider : ResourceSupplier {

    fun getFile(): File
    fun getFilePath(): String

    fun toBarSeries(name: String = "IO Default"): BarSeries
    fun read(): MutableList<MarketData>
    fun write(inMarketDataList: MutableList<MarketData>? = null): Boolean
}