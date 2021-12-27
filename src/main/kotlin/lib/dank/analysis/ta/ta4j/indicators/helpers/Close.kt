package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.conditions.helpers.CloseConditions
import lib.dank.analysis.ta.IndicatorConditionsDecorator
import lib.dank.analysis.ta.conditions.executor.ZonedConditionsExecutor
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
open class Close(

    val MarketDataList: MutableList<MarketData>,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val conditions: CloseConditions = CloseConditions(MarketDataList),
    override val rawIndicator: ClosePriceIndicator = ClosePriceIndicator(adapter.toBarSeries(MarketDataList))

) : ZonedConditionsExecutor, IndicatorConditionsDecorator<ClosePriceIndicator, CloseConditions>


