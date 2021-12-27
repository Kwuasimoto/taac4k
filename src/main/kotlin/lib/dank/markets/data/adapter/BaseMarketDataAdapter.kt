package lib.dank.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.analysis.ta.enums.OHLCV
import lib.dank.markets.data.MarketData
import lib.dank.markets.data.enums.TIMESPAN
import lib.dank.markets.data.factory.BaseMarketDataFactory
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum

open class BaseMarketDataAdapter(
    open val marketDataFactory: BaseMarketDataFactory = BaseMarketDataFactory()
) : MarketDataAdapter {

    override fun convert(barSeries: BarSeries): MutableList<MarketData> = marketDataFactory.fromBarSeries(barSeries)

    override fun toBarSeries(from: MutableList<MarketData>, name: String): BarSeries =
        if (from.size <= 0) throw IllegalArgumentException("marketDataJSONList is empty!, cant adapt")
        else {
            val barList = BaseBarSeriesBuilder()
                .withName(name)
                .withNumTypeOf(DecimalNum::class.java)
                .build()

            for (marketData in from) {
                barList.addBar(
                    BaseBar(
                        marketDataFactory.date.toDuration(TIMESPAN.valueOf(marketData.timespan), marketData.multiplier),
                        marketDataFactory.date.toZonedDateTime(marketData.endTime),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.OPEN]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.HIGH]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.LOW]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.CLOSE]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.VOLUME]),
                        DecimalNum.valueOf(marketData.ohlcv[OHLCV.VWAP])
                    )
                )
            }

            barList
        }

    override fun convert(aggregates: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> {
        val newMarketDataList = newList

        for (aggregate in aggregates.results)
            newMarketDataList.add(marketDataFactory.fromAggregate(aggregate, params))

        return newMarketDataList
    }

}