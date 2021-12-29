package lib.taac4k.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.analysis.ta.ta4j.BaseBarSeriesFactory
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.factory.BaseMarketDataFactory
import org.ta4j.core.BarSeries

open class BaseMarketDataAdapter(
    open val marketDataFactory: BaseMarketDataFactory = BaseMarketDataFactory(),
    open val barSeriesFactory: BaseBarSeriesFactory = BaseBarSeriesFactory()
) : MarketDataAdapter {

    override fun convert(from: BarSeries): MutableList<MarketData> =
        marketDataFactory.fromBarSeries(from)

    override fun toBarSeries(from: MutableList<MarketData>, name: String): BarSeries =
        barSeriesFactory.fromMarketDataList(from)

    override fun convert(from: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> =
        marketDataFactory.fromAggregates(from, params)
}