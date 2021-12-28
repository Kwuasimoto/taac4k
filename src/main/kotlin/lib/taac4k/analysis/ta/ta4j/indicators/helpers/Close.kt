package lib.taac4k.analysis.ta.ta4j.indicators.helpers

import lib.taac4k.analysis.ta.BaseConditions
import lib.taac4k.analysis.ta.conditions.helpers.CloseConditions
import lib.taac4k.analysis.ta.IndicatorConditions
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider
import lib.taac4k.markets.data.adapter.MarketDataAdapter
import lib.taac4k.markets.data.adapter.BaseMarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.num.Num


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
open class Close(

    val marketDataList: MutableList<MarketData>,

    override val adapter: BaseMarketDataAdapter = MarketDataAdapter(),
    override val conditions: CloseConditions = CloseConditions(marketDataList),
    override val values: MarketDataValuesProvider = MarketDataValuesProvider(marketDataList),
    override val rawIndicator: Indicator<Num> = ClosePriceIndicator(adapter.toBarSeries(marketDataList)),

    ) : IndicatorConditions<BaseConditions>


