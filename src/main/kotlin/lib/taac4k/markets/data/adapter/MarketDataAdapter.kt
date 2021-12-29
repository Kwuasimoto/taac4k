package lib.taac4k.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataMutableListSupplier
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeries

/**
 * 2-way adapter
 */
interface MarketDataAdapter : MarketDataMutableListSupplier {

    /**
     * Individual technical analysis lib conversions
     */
    fun toBarSeries(from: MutableList<MarketData>, name: String = "Lunos"): BarSeries = BaseBarSeries()

    /**
     * toMarketData Overloads
     */
    fun convert(from: BarSeries): MutableList<MarketData> = newList
    fun convert(from: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> = newList
}