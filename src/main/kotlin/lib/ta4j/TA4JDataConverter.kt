package lib.ta4j

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import lib.MarketData
import org.ta4j.core.BaseBarSeries
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DoubleNum
import org.ta4j.core.num.Num
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.time.Duration

interface TA4JDataConverter {

    // Date Formatter
    val standardDateFormat
        get() = SimpleDateFormat("yyyy-MM-dd")

    val baseBarSeries: BaseBarSeries
        get() = BaseBarSeriesBuilder()
            .withNumTypeOf(DoubleNum::valueOf) // Increase performance according to docs
            .withName("Lunos")
            .build()

    fun <T> smartConvertDTO(results: T, duration: Duration): List<MarketData> =

        when (results) {

            is AggregatesDTO -> convertPolygonAggregatesDTO(results, duration)

            else -> throw IllegalArgumentException("Generic not recognized.")
        }

    /**
     * INDIVIDUAL CONVERTERS
     *
     *  - POLYGON
     * [convertPolygonAggregatesDTO]
     */

    /**
     * polygon aggregatesDTO.result conversion.
     */
    private fun convertPolygonAggregatesDTO(dto: AggregatesDTO, duration: Duration): List<MarketData> {
        val marketData: MutableList<MarketData> = mutableListOf()

        for (result in dto.results) {
            val instant = result.timestampMillis?.let { Instant.ofEpochMilli(it) }
            val localDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())

            marketData.add(
                MarketData(
                    duration,
                    localDateTime,
                    mapOf<String, Num>(
                        "openPrice" to DoubleNum.valueOf(result.open),
                        "highPrice" to DoubleNum.valueOf(result.high),
                        "lowPrice" to DoubleNum.valueOf(result.low),
                        "closePrice" to DoubleNum.valueOf(result.close)
                    )
                )
            )
        }

        return marketData
    }
}
