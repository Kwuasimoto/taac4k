package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData

interface PositionalConditions : ComplexConditions {
    fun isOver(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun isUnder(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossOver(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean

    fun crossUnder(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
}