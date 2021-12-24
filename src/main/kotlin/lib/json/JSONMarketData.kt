package lib.ta.ta4j.suppliers

import com.fasterxml.jackson.databind.ObjectMapper
import org.json.JSONObject
import org.json.JSONWriter
import org.ta4j.core.BarSeries
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

open class JSONMarketData(
    private val url: String,
    val path: Path = Paths.get(url),
    val file: File = path.toFile(),
    val bytes: ByteArray = Files.readAllBytes(path),
    val raw: String = String(bytes),
    val json: JSONObject = JSONObject(raw),

    private val writer: JSONWriter = JSONWriter(FileWriter(file))
) {
    fun write() {

    }

    inline fun <reified T> parse(): T =
        when(T::class.java){
            is BarSeries -> {



            } else -> throw IllegalArgumentException("Generic not recognized!")
        }
}


fun JSONMarketData.write() {

}

inline fun <reified T> JSONMarketData.parse() : T =
    when(T::class) {
        is BarSeries -> {

        }
        else -> throw IllegalStateException("Generic not recognized")
    }

/**
 * Nice to have, compatible with all bean types
 */
inline fun <reified T> String.toKotlinType(): T =
    ObjectMapper().readValue(this, T::class.java)

