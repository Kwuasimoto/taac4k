package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.helpers.CloseConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.ta4j.indicators.Conditions
import lib.dank.analysis.ta.ta4j.indicators.decorators.WithZonedCondition
import lib.dank.markets.MarketDataJSON
import org.ta4j.core.indicators.helpers.ClosePriceIndicator


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
open class Close(

    open val marketDataJSONList: MutableList<MarketDataJSON>,
    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val conditions: CloseConditions = CloseConditions(marketDataJSONList),
    override val rawIndicator: ClosePriceIndicator = ClosePriceIndicator(adapter.toBarSeries(marketDataJSONList))

) : WithZonedCondition, Conditions<ClosePriceIndicator, CloseConditions>


