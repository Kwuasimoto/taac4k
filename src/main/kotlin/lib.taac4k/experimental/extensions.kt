package lib.taac4k.experimental

// Works :o
// T::class.java.hasInterface();
fun <T> Class<T>.hasInterface(face: Class<*>): Boolean = this.interfaces.any { it === face }
//
//fun MutableList<MarketDataJSON>.toBarSeries(): BarSeries {
//    /**
//     * @TA4J#BarSeries to [MarketDataJSON] conversion
//     */
//        val barSeries: BarSeries = BaseBarSeries()
//
//        for (marketData in this) {
//            barSeries.addBar(
//                BaseBar(
//                    marketData.period,
//                    marketData.endTime,
//                    DecimalNum.valueOf(marketData.open),
//                    DecimalNum.valueOf(marketData.high),
//                    DecimalNum.valueOf(marketData.low),
//                    DecimalNum.valueOf(marketData.close),
//                    DecimalNum.valueOf(marketData.volume),
//                    DecimalNum.valueOf(marketData.vwap)
//                )
//            )
//        }
//
//        return barSeries
//    }
//
///**
// * Java Compatibility
// * @param marketDataList marketDataList Object to convert to Object [barList]
// * @param barList object to convert [marketDataList] to
// */
//fun <T> toBarSeries(marketDataList: MutableList<MarketDataJSON>, barList: T): T =
//
//    /**
//     * @MarketDataJSON from [BaseBarSeries] conversion
//     */
//
//    if (barList is BaseBarSeries) {
//        for (marketData in marketDataList)
//            barList.addBar(
//                BaseBar(
//                    marketData.period,
//                    marketData.endTime,
//                    DecimalNum.valueOf(marketData.open),
//                    DecimalNum.valueOf(marketData.high),
//                    DecimalNum.valueOf(marketData.low),
//                    DecimalNum.valueOf(marketData.close),
//                    DecimalNum.valueOf(marketData.volume),
//                    DecimalNum.valueOf(marketData.vwap)
//                )
//            )
//
//        barList
//    } else {
//        throw IllegalArgumentException("Generic not recognized. Check Compatible TA Libraries [TA4J#BarSeries]")
//    }

//inline fun <reified T : Any> MutableList<MarketDataJSON>.from(
//    any: T
//): MutableList<MarketDataJSON> =
//
//    if (BaseBarSeries::class.java.hasInterface(any::class.java)) {
//        any as AggregatesDTO
//
//        for (barDatum in any.results)
//            this.add(
//                MarketDataJSON(
//                    ticker,
//                    barDatum.openPrice,
//                    barDatum.highPrice,
//                    barDatum.lowPrice.,
//                    barDatum.closePrice,
//                    barDatum.volume,
//                    barDatum.endTime,
//                    barDatum.timePeriod,
//                    barDatum.amount.doubleValue()
//                )
//            )
//
//        /**
//         * @return
//         */
//        this
//
//    } else throw IllegalArgumentException("Generic not recognized. Check Compatible TA Libraries [TA4J#BarSeries]")
//
