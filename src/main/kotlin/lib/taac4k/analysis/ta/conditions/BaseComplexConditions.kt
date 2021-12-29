package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

/**
 * @TODO
 */
open class BaseComplexConditions(
    override val marketDataMutableList: MutableList<MarketData>,
    override val values: MarketDataValuesProvider
) : BaseValueConditions(marketDataMutableList, values), ComplexConditions {

    override fun pivotUp(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean { TODO() }

    override fun pivotDown(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean { TODO() }

    override fun bullishDivergence(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean { TODO() }

    override fun bearishDivergence(
        leftBarIndex: Int,
        rightBarIndex: Int,
        leftBarOHLCV: OHLCV,
        rightBarOHLCV: OHLCV
    ): Boolean { TODO() }

    override fun hiddenBullishDivergence(): Boolean { TODO() }
    override fun hiddenBearishDivergence(): Boolean { TODO() }

    override fun isBullish(): Boolean { TODO() }
    override fun isBearish(): Boolean { TODO() }
}