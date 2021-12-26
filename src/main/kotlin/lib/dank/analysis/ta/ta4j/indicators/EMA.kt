package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.EMAConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.ta4j.indicators.decorators.WithZonedCondition
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import org.ta4j.core.indicators.EMAIndicator

open class EMA(
    close: Close,
    barCount: Int = 12,

    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val conditions: EMAConditions =
        EMAConditions(close.marketDataJSONList),

    override val indicator: EMAIndicator =
        EMAIndicator(close.indicator, barCount)

) : WithZonedCondition, ConditionsSupplier<EMAIndicator, EMAConditions>