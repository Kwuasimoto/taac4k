package lib.polygon
import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import org.ta4j.core.BarSeries

/**
 *   ░░░░░░░░░░
 *   ░░░░░▄▀░░░░░░░░░░░░░
 *   ░░░░█░▄██░░░░░░██▄░░
 *   ░░░█▄▀▄▄░█░░░░█░▄░█▄
 *   ░░▄▀░▀▀▀▀░░░░░░▀▀▀░░
 *   ▄▀░░░░░░░░░░░░▄░░░░░
 *   █░░░░█░░░░░░▄▄▀░░░░░
 *   █░▄▀▄░▀▀▀▀▀▀░░░▄▀▀▄░
 *   ▀▄▀░░▀▀▄▄▄▄▄(_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅ () ด้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็ .
 *   ░▀▄░░░░░░░░░░░░░░░░░
 *   ░░█░░░░░░░░░░░░░░░░░
 *
 *   Here I am unsure of dependancy inversion,
 *   my gut tells me that a [PolygonBarSeriesBuilder] *can be*
 *   a [PolygonBarBuilder], but saying it *is a*
 *   removes dependancy inversion
 */
open class PolygonBarSeriesBuilder(
    /**
     * *Has A* relationship
     */
    private val builder: PolygonBarBuilder = PolygonBarBuilder()
) {
    fun parsePolygonAggregatesDTO(
        /**
         * *Uses A* Relationship
         */
        aggregates: AggregatesDTO,
        params:AggregatesParameters
    ): BarSeries {
        val barSeries: BarSeries = builder.baseBarSeries
            .withName("Lunos")
            .build()

        for (result in aggregates.results)
            barSeries.addBar(builder.parseDTO(result, params))

        return barSeries
    }
}
