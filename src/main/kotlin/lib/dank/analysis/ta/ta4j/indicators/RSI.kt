package lib.dank.analysis.ta.ta4j.indicators

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.analysis.ta.conditions.IndicatorConditions
import lib.dank.analysis.ta.conditions.RSIConditions
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import org.ta4j.core.indicators.RSIIndicator

open class RSI(
    close: Close,

    barCount: Int = 12,

    override val adapter: MarketAnalysisAdapter = TA4JAdapter(),

    override val rawIndicator: RSIIndicator =
        RSIIndicator(close.rawIndicator, barCount),

    override val conditions: RSIConditions =
        RSIConditions(close.JSONMarketDataList)

) : IndicatorConditions<RSIIndicator, RSIConditions>