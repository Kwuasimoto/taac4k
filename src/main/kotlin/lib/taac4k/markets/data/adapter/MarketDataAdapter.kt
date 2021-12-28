package lib.taac4k.markets.data.adapter

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.taac4k.analysis.ta.enums.OHLC
import lib.taac4k.markets.data.MarketData
import lib.taac4k.markets.data.enums.TIMESPAN
import lib.taac4k.markets.data.factory.BaseMarketDataFactory
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum

open class MarketDataAdapter(
    open val marketDataFactory: BaseMarketDataFactory = BaseMarketDataFactory()
) : BaseMarketDataAdapter {

    override fun convert(from: BarSeries): MutableList<MarketData> = marketDataFactory.fromBarSeries(from)

    override fun convert(from: MutableList<MarketData>, name: String): BarSeries =
        if (from.size <= 0) throw IllegalArgumentException("marketDataJSONList is empty!, cant adapt")
        else {
            val barList = BaseBarSeriesBuilder()
                .withName(name)
                .withNumTypeOf(DecimalNum::class.java)
                .build()

            println("Can we get some data in the fucking console intellij?")
            for (marketData in from) {
                barList.addBar(
                    BaseBar(
                        marketDataFactory.date.toDuration(TIMESPAN.valueOf(marketData.timespan), marketData.multiplier),
                        marketDataFactory.date.toZonedDateTime(marketData.endTime),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.OPEN]),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.HIGH]),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.LOW]),
                        DecimalNum.valueOf(marketData.ohlc[OHLC.CLOSE]),
                        DecimalNum.valueOf(marketData.volume),
                        DecimalNum.valueOf(marketData.vwap)
                    )
                )
            }

            barList
        }

    override fun convert(from: AggregatesDTO, params: AggregatesParameters): MutableList<MarketData> {
        val newMarketDataList = newList

        for (aggregate in from.results)
            newMarketDataList.add(marketDataFactory.fromAggregate(aggregate, params))

        return newMarketDataList
    }

}