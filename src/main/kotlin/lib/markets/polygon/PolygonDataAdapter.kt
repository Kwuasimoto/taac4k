package lib.markets.polygon
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.markets.MarketData

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
 *   my gut tells me that a [PolygonDataAdapter] *can be*
 *   a [PolygonMarketDataConverter], but saying it *is a*
 *   removes dependancy inversion
 */

class PolygonDataAdapter(
    /**
     * *Has A* relationship
     */
    private val converter: PolygonMarketDataConverter = PolygonMarketDataConverter()
) {
    fun parsePolygonAggregatesDTO(
        /**
         * *Uses A* Relationship
         */
        aggregates: AggregatesDTO,
        params:AggregatesParameters,
        marketDataSeries: MutableList<MarketData> = mutableListOf()
    ): MutableList<MarketData> {
        for (result in aggregates.results)
            marketDataSeries.add(converter.transformAggregate(result, params))

        return marketDataSeries
    }
}
