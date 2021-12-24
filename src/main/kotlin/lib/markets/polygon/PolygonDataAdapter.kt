package lib.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.markets.MarketData

interface PolygonDataAdapter {
    fun parsePolygonAggregatesDTO(
        /**
         * *Uses A* Relationship
         */
        aggregates: AggregatesDTO,
        params: AggregatesParameters,
        marketDataSeries: MutableList<MarketData> = mutableListOf()
    ): MutableList<MarketData>
}
