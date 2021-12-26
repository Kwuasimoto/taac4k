package lib.dank.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.data.MarketDataAdapter
import lib.dank.markets.data.factory.JSONMarketDataFactory

open class PolygonDataAdapter(
    open val jsonMarketDataFactory: JSONMarketDataFactory = JSONMarketDataFactory()

) : MarketDataAdapter {

    override fun from(
        aggregates: AggregatesDTO,
        params: AggregatesParameters
    ): MutableList<JSONMarketData> {
        val newMarketDataList = newList

        for (aggregate in aggregates.results)
            newMarketDataList.add(jsonMarketDataFactory.fromAggregate(aggregate, params))

        return newMarketDataList
    }
}
