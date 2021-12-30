package lib.taac4k.analysis.ta.ta4j.indicators

import lib.taac4k.analysis.ta.conditions.BasePositionalConditions
import lib.taac4k.analysis.ta.conditions.PositionalConditions
import lib.taac4k.analysis.ta.ta4j.indicators.helpers.Volume
import lib.taac4k.markets.data.MarketDataValues
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.indicators.WMAIndicator

class VWMA(
    val volume: Volume,
    val vwmaLength: Int = 200,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val values: MarketDataValuesProvider = MarketDataValues(volume.marketDataList),
    override val rawIndicator: WMAIndicator = WMAIndicator(volume.rawIndicator, vwmaLength),
    override val conditions: PositionalConditions = BasePositionalConditions(volume.marketDataList, values)

) : ConditionalIndicator