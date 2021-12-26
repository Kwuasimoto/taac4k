package lib.dank.markets

import org.ta4j.core.BarSeries
import java.io.FileWriter
import java.util.*

class MarketDataIO(
    val basePath: String = "resources/json/market_data/",
    val fileID: UUID = UUID.randomUUID(),
    val filePath: String = "${basePath}market_data_${fileID}.json",

    ) {

    inline fun <reified T> parseFileToType(): T =
        when (T::class) {
            is BarSeries -> {
                TODO("")
            }
            else -> throw IllegalArgumentException("Generic not recognized. Check Compatible TA Libraries [TA4J#BarSeries]")
        }

    fun write(io: FileWriter) = io.write(super.toString())
}


