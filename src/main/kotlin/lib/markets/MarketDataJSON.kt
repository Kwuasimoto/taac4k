package lib.markets

import org.json.JSONObject
import org.ta4j.core.BarSeries
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * Keys
 *  val ticker: String?,
    val open: Double?,
    val high: Double?,
    val low: Double?,
    val close: Double?,
    val volume: Double?,
    val period: Duration?,

    //Volume weighted average price
    val vwap: Double?
 */


class MarketDataJSON(
    // Configurables
    private val basePath: String = "resources/json/market_data/",

    val data: MarketData,

    val fileID: UUID = UUID.randomUUID(),
    val filePath: String = "${basePath}market_data_${fileID}.json",

    val fileBytes: ByteArray = Files.readAllBytes(Paths.get(filePath).first()),
    val json: JSONObject = JSONObject(fileBytes),

) : JSONObject(data) {

    inline fun <reified T> parseJSONToType(): T =
        when(T::class){

        }

    inline fun <reified T> parseFileToType(): T =
        when(T::class) {
            is BarSeries -> {

            }
            else -> throw IllegalArgumentException("Generic not recognized. Check Compatible TA Libraries [TA4J#BarSeries]")
        }


    fun write(io: FileWriter) = io.write(json.toString())
}