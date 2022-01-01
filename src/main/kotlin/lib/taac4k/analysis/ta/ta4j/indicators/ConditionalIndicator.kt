package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.ValueConditions
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.num.Num

/**
 * ## ConditionalIndicator
 * Generic interface for ConditionalIndicators
 *
 * Acts as a decorator for Analysis Library Decorators.
 *
 * ### Want to integrate your own Analysis Library instead of TA4J?
 *
 * Swap out the rawIndicator Type here from TA4J to your libraries generic indicator interface.
 *
 * *then* re-implement your own module similar to the analysis.ta.ta4j module. Feel free to use it as a template.
 */
interface ConditionalIndicator {
    /**
     * adapter for assisting in converting data for checking conditions.
     */
    val adapter: MarketDataAdapter
    /**
     * values object that provides utility methods for getting data out of a [MutableList]<[MarketData]>
     */
    val values: MarketDataValuesProvider
    /**
     * Technical Analysis lib integration here
     */
    val rawIndicator: Indicator<Num>
    /**
     * conditions param that holds the conditions for each indicator.
     */
    val conditions: ValueConditions
}