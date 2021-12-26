package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.helpers.CloseConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.conditions.IndicatorConditions
import lib.dank.analysis.ta.conditions.executor.ZonedConditionsExecutor
import lib.dank.markets.data.JSONMarketData
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
open class Close(

    open val JSONMarketDataList: MutableList<JSONMarketData>,
    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val conditions: CloseConditions = CloseConditions(JSONMarketDataList),
    override val rawIndicator: ClosePriceIndicator = ClosePriceIndicator(adapter.toBarSeries(JSONMarketDataList))

) : ZonedConditionsExecutor, IndicatorConditions<ClosePriceIndicator, CloseConditions>


