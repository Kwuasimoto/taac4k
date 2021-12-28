package lib.taac4k.analysis.ta

import lib.taac4k.analysis.ta.conditions.helpers.CloseConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Volume
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.BarSeries
import org.ta4j.core.Indicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.num.Num

/**
 * ## Lunos Indicators Class
 *
 * *Helpers*
 * - Close
 * - Volume
 *
 * *Indicators*
 * 1. RSI
 * 2. SMA
 * 3. EMA
 * 4. VWMA
 * 5. PSAR
 * 6. ADX
 * 7. STOCH (Bonus if I get to it today)
 * 8. On-Balance Volume
 */

open class IndicatorFactory(
    override val marketDataList: MutableList<MarketData>,
    override val adapter: MarketDataAdapter = BaseMarketDataAdapter()
) : BaseIndicatorFactory {

    private val barSeries: BarSeries = adapter.toBarSeries(marketDataList, "Bar Series Name.")

    open fun close(rootIndicator: Indicator<Num>? = null): Close =
        Close(marketDataList, adapter, CloseConditions(marketDataList), rootIndicator ?: ClosePriceIndicator(barSeries))
}




