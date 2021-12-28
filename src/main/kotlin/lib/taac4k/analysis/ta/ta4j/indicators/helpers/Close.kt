package lib.dank.analysis.ta.ta4j.indicators.helpers

import lib.dank.analysis.ta.conditions.helpers.CloseConditions
import lib.dank.analysis.ta.IndicatorConditions
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.adapter.BaseMarketDataAdapter
import lib.dank.markets.data.adapter.MarketDataAdapter
import org.ta4j.core.Indicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.num.Num


/**
 * All Indicators extend fooIndicator which implements Indicator<fooIndicator>
 */

//@TestAnnotation(ClosePriceIndicator::class, CloseConditions::class)
open class Close(

    open val marketDataList: MutableList<MarketData>,

    override val adapter: MarketDataAdapter = BaseMarketDataAdapter(),
    override val conditions: CloseConditions = CloseConditions(marketDataList),
    override val rawIndicator: Indicator<Num> = ClosePriceIndicator(adapter.toBarSeries(marketDataList))

) : IndicatorConditions<CloseConditions>


