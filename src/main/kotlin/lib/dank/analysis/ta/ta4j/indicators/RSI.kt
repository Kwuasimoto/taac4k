package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.RSIConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.ta4j.indicators.decorators.WithZonedCondition
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import org.ta4j.core.indicators.RSIIndicator

open class RSI(
    close: Close,

    barCount: Int = 12,

    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val indicator: RSIIndicator =
        RSIIndicator(close.indicator, barCount),

    override val conditions: RSIConditions =
        RSIConditions(close.marketDataJSONList)

) : WithZonedCondition, ConditionsSupplier<RSIIndicator, RSIConditions>