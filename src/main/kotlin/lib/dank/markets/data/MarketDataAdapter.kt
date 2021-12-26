package lib.dank.markets.data

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.suppliers.MarketDataJSONListSupplier

/**
 * 1-way adapter
 */
interface MarketDataAdapter : MarketDataJSONListSupplier {
    fun from(aggregates: AggregatesDTO, params: AggregatesParameters): MutableList<JSONMarketData>
}