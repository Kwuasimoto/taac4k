package lib.taac4k.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataMutableListSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeries

/**
 * 2-way adapter for converting T Provider data to [MutableList]<[MarketData]>
 * and [MutableList]<[MarketData]> to Analysis Library compatible Types
 */
interface MarketDataAdapter : MarketDataMutableListSupplier {
    /**
     * ## toBarSeries
     * Convert a [MutableList]<[MarketData]> to a [BarSeries]
     * @param from the [MutableList]<[MarketData]> to get a [BarSeries] from
     * @param name the name of the [BarSeries]
     * @return [BarSeries]
     */
    fun toBarSeries(from: MutableList<MarketData>, name: String = "Lunos"): BarSeries = BaseBarSeries()
    /**
     * ## convert
     * a [BarSeries] to a [MutableList]<[MarketData]>
     * @param from supply a [BarSeries] to get a [MutableList]<[MarketData]>
     * @return [MutableList]<[MarketData]>
     */
    fun convert(from: BarSeries): MutableList<MarketData> = newList
    /**
     * ## convert
     * [AggregatesDTO] from polygon to a [MutableList]<[MarketData]>
     * @param from supply [AggregatesDTO] to get a [MutableList]<[MarketData]>
     * @param params supply [AggregatesParameters] (Needed for finding duration w/ multiplier)
     * @return [MutableList]<[MarketData]>
     */
    fun convert(from: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> = newList
}