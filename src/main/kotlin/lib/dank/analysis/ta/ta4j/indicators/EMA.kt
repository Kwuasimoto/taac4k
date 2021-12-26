package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.IndicatorConditions
import lib.dank.analysis.ta.conditions.EMAConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.conditions.executor.ZonedConditionsExecutor
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import org.ta4j.core.indicators.EMAIndicator

open class EMA(
    close: Close,
    barCount: Int = 12,

    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val conditions: EMAConditions =
        EMAConditions(close.JSONMarketDataList),

    override val rawIndicator: EMAIndicator =
        EMAIndicator(close.rawIndicator, barCount)

) : ZonedConditionsExecutor, IndicatorConditions<EMAIndicator, EMAConditions>