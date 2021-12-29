package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.analysis.ta.conditions.OBVConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Close
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.indicators.volume.OnBalanceVolumeIndicator

open class OBV(
    open val close: Close,

    override val adapter: BaseMarketDataAdapter = close.adapter,
    override val values: MarketDataValuesProvider = MarketDataValues(close.marketDataList),

    override val rawIndicator: OnBalanceVolumeIndicator =
        OnBalanceVolumeIndicator(adapter.toBarSeries(close.marketDataList)),
    override val conditions: OBVConditions = OBVConditions(close.marketDataList, values)

) : IndicatorConditions<OBVConditions>