package lib.polygon

import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.ta4j.TA4JBarBuilderSupplier
import org.ta4j.core.Bar
import org.ta4j.core.num.DoubleNum

class PolygonBarBuilder(
    private val date: PolygonDateParser = PolygonDateParser()
): TA4JBarBuilderSupplier {

    fun parseDTO(result: AggregateDTO, params: AggregatesParameters): Bar {
        return barBuilder
            .timePeriod(date.parseDuration(params.timespan, params.multiplier))
            .endTime(date.parseMillis(result.timestampMillis))
            .openPrice(DoubleNum.valueOf(result.open))
            .highPrice(DoubleNum.valueOf(result.high))
            .lowPrice(DoubleNum.valueOf(result.low))
            .closePrice(DoubleNum.valueOf(result.close))
            .volume(DoubleNum.valueOf(result.volume))
            .build()
    }

    fun parseDTO(other: String): Bar {
        throw Error("Not Implemented")
    }
}