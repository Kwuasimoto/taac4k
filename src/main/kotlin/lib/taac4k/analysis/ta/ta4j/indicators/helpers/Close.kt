package lib.taac4k.analysis.ta.ta4j.indicators.helpers

import lib.taac4k.analysis.ta.conditions.BasePositionalConditions
import lib.taac4k.analysis.ta.conditions.PositionalConditions
import lib.taac4k.analysis.ta.ta4j.indicators.ConditionalIndicator
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

open class Close(

    val marketDataList: MutableList<MarketData>,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val values: MarketDataValuesProvider = MarketDataValues(marketDataList),

    override val rawIndicator: ClosePriceIndicator = ClosePriceIndicator(adapter.toBarSeries(marketDataList)),
    override val conditions: PositionalConditions = BasePositionalConditions(marketDataList, values)

) : ConditionalIndicator


