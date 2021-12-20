package lib.ta4j
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import org.ta4j.core.BarSeries
import org.ta4j.core.num.DoubleNum
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

abstract class TA4JPolygonBarBuilder: TA4JBarBuilderProvider() {

    /**
     *
     */
    protected fun convertPolygonAggregatesDTO(polygonClient: PolygonRestClient, params:AggregatesParameters): BarSeries {
        val barSeries: BarSeries = baseBarSeries.withName("Lunos").build()
        val aggregates = polygonClient.getAggregatesBlocking(params)

        for (result in aggregates.results) {

            val instant = result.timestampMillis?.let { Instant.ofEpochMilli(it) }
            val localDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())

            barSeries.addBar(
                barBuilder
                    .timePeriod(this.getDuration(params.timespan, params.multiplier))
                    .endTime(localDateTime)
                    .openPrice(DoubleNum.valueOf(result.open))
                    .highPrice(DoubleNum.valueOf(result.high))
                    .lowPrice(DoubleNum.valueOf(result.low))
                    .closePrice(DoubleNum.valueOf(result.close))
                    .volume(DoubleNum.valueOf(result.volume))
                    .build()

            )
        }

        return barSeries
    }

    /**
     *
     */
    private fun getDuration(timespan: String, multiplier: Long): Duration =
        when (timespan) {
            "minute" -> Duration.ofMinutes(multiplier)
            "hour" -> Duration.ofHours(multiplier)
            "day" -> Duration.ofDays(multiplier)
            else -> throw IllegalArgumentException("Timespan not recognized")
        }

}
