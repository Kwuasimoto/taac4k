package lib.markets.polygon
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
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
 *   my gut tells me that a [PolygonBarSeriesParser] *can be*
 *   a [PolygonBarBuilder], but saying it *is a*
 *   removes dependancy inversion
 */
open class PolygonBarSeriesParser(
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
