package lib.dank.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.MarketDataListSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeries

/**
 * 2-way adapter
 */
interface MarketDataAdapter : MarketDataListSupplier {
    fun convert(barSeries: BarSeries): MutableList<MarketData> = mutableListOf()
    fun toBarSeries(from: MutableList<MarketData>, name: String = "Lunos"): BarSeries = BaseBarSeries()

    fun convert(aggregates: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> = mutableListOf()
}