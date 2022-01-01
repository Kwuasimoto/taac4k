package lib.taac4k.analysis.ta.conditions

import lib.taac4k.analysis.ta.enums.OHLCV
import lib.taac4k.markets.data.MarketData

/**
 * ## PositionalConditions
 *
 * Generic conditions for checking if *this* [ConditionalIndicator]'s
 * marketDataList's value at some index is greater than a
 * comparable lists value at the specific index.
 */
interface PositionalConditions : ComplexConditions {
    /**
     * ## isOver
     * Checks if the value in *this* [ConditionalIndicator]'s marketDataList is
     * over the [comparableList]'s value at the specified [comparableValueIndex]
     * @param comparableList the list to compare against *this* [ConditionalIndicator]'s marketDataList'
     * @param comparableValueIndex the index to end the check at
     * @param startValueIndex the index to begin checking *this* [ConditionalIndicator]'s marketDataList' values at.
     * @param comparableOHLCV check the open, high, low, close, vwap values of the comparable list.
     * @param ohlcv check the open, high, low, close, vwap values of *this* [ConditionalIndicator]'s marketDataList' value.
     * @return [Boolean]
     */
    fun isOver(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## isUnder
     * Checks if the value in *this* [ConditionalIndicator]'s marketDataList is
     * under the [comparableList]'s value at the specified [comparableValueIndex]
     * @param comparableList the list to compare against *this* [ConditionalIndicator]'s marketDataList'
     * @param comparableValueIndex the index to end the check at
     * @param startValueIndex the index to begin checking *this* [ConditionalIndicator]'s marketDataList' values at.
     * @param comparableOHLCV check the open, high, low, close, vwap values of the comparable list.
     * @param ohlcv check the open, high, low, close, vwap values of *this* [ConditionalIndicator]'s marketDataList' value.
     * @return [Boolean]
     */
    fun isUnder(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 1,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## crossOver
     * Checks if the value in *this* [ConditionalIndicator]'s marketDataList has
     * crossed over the [comparableList]'s value at the specified [comparableValueIndex]
     * @param comparableList the list to compare against *this* [ConditionalIndicator]'s marketDataList'
     * @param comparableValueIndex the index to end the check at
     * @param startValueIndex the index to begin checking *this* [ConditionalIndicator]'s marketDataList' values at.
     * @param comparableOHLCV check the open, high, low, close, vwap values of the comparable list.
     * @param ohlcv check the open, high, low, close, vwap values of *this* [ConditionalIndicator]'s marketDataList' value.
     * @return [Boolean]
     */
    fun crossOver(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
    /**
     * ## crossUnder
     * Checks if the value in *this* [ConditionalIndicator]'s marketDataList has
     * crossed under the [comparableList]'s value at the specified [comparableValueIndex]
     * @param comparableList the list to compare against *this* [ConditionalIndicator]'s marketDataList'
     * @param comparableValueIndex the index to end the check at
     * @param startValueIndex the index to begin checking *this* [ConditionalIndicator]'s marketDataList' values at.
     * @param comparableOHLCV check the open, high, low, close, vwap values of the comparable list.
     * @param ohlcv check the open, high, low, close, vwap values of *this* [ConditionalIndicator]'s marketDataList' value.
     * @return [Boolean]
     */
    fun crossUnder(

        comparableList: MutableList<MarketData>,

        comparableValueIndex: Int = comparableList.size - 1,
        startValueIndex: Int = values.barCount - 2,

        comparableOHLCV: OHLCV = OHLCV.CLOSE,
        ohlcv: OHLCV = OHLCV.CLOSE

    ): Boolean
}