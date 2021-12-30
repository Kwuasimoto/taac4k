package lib.taac4k.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataMutableListSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeries

/**
 * 2-way adapter for converting Provider data to Analysis data
 * @version 0.0.1
 */
interface MarketDataAdapter : MarketDataMutableListSupplier {

    /**
     * Convert a [MutableList]<[MarketData]> to a [BarSeries]
     */
    fun toBarSeries(from: MutableList<MarketData>, name: String = "Lunos"): BarSeries = BaseBarSeries()

    /**
     * Convert a [BarSeries] to a [MutableList]<[MarketData]>
     */
    fun convert(from: BarSeries): MutableList<MarketData> = newList

    /**
     * Convert [AggregatesDTO] from polygon to a [MutableList]<[MarketData]>
     */
    fun convert(from: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> = newList
}