package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.BasePositionalConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.volume.OnBalanceVolumeIndicator

open class OBV(
    open val close: Close,

    override val adapter: MarketDataAdapter = close.adapter,
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),

    override val rawIndicator: OnBalanceVolumeIndicator =
        OnBalanceVolumeIndicator(adapter.toBarSeries(close.marketDataList)),
    override val conditions: BasePositionalConditions = BasePositionalConditions(close.marketDataList, values)

) : ConditionalIndicator