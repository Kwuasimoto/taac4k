package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.MarketDataValuesProvider

open class BasePositionalConditions(
    override val marketDataMutableList: MutableList<MarketData>,
    override val values: MarketDataValuesProvider
) : BaseComplexConditions(marketDataMutableList, values), PositionalConditions {

    override fun isOver(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV
    ): Boolean =
        if (comparableValueIndex < 0 || startValueIndex < 0)
            throw IllegalArgumentException("comparableIndex or barIndex cannot be less than 0!")
        else
            values.barValue(startValueIndex, ohlcv) >
            values.barValue(comparableList, comparableValueIndex, comparableOHLCV)

    override fun isUnder(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV
    ): Boolean =
        !isOver(comparableList, comparableValueIndex, startValueIndex, comparableOHLCV, ohlcv)

    override fun crossOver(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV,
    ): Boolean {
        // If initial check shows price is already over comparableList value at comparableValueIndex, return false
        if (isOver(comparableList, comparableValueIndex, startValueIndex, comparableOHLCV, ohlcv))
            return cache.boolCache

        //
        for (i in 1 until marketDataMutableList.size) {
            if (cache.boolCache || i + startValueIndex == marketDataMutableList.size) break
            if (isOver(comparableList, comparableValueIndex, startValueIndex + i, comparableOHLCV, ohlcv))
                cache.boolCache = true
        }

        return cache.reset()
    }

    override fun crossUnder(
        comparableList: MutableList<MarketData>,
        comparableValueIndex: Int,
        startValueIndex: Int,
        comparableOHLCV: OHLCV,
        ohlcv: OHLCV

    ): Boolean {
        // Check if value is above or below target on first iteration, return false if so,
        if (isUnder(comparableList, comparableValueIndex, startValueIndex, comparableOHLCV, ohlcv))
            return cache.boolCache

        for (i in 1 until marketDataMutableList.size){
            if (cache.boolCache || i + startValueIndex == marketDataMutableList.size) break
            if (isUnder(comparableList, comparableValueIndex, startValueIndex + i, comparableOHLCV, ohlcv))
                cache.boolCache = true
        }

        return cache.reset()
    }
}