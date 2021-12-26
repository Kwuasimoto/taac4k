package lib.dank.analysis.ta.ta4j

import lib.dank.analysis.ta.MarketAnalysisAdapter
import lib.dank.markets.data.JSONMarketData
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBar
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.num.DecimalNum

class TA4JAdapter : MarketAnalysisAdapter {
    override fun toBarSeries(JSONMarketDataList: MutableList<JSONMarketData>, name: String): BarSeries =
        if (JSONMarketDataList.size <= 0) throw IllegalArgumentException("marketDataJSONList is empty!, cant adapt")

        else {
            val barList = BaseBarSeriesBuilder()
                .withName(name)
                .withNumTypeOf(DecimalNum::class.java)
                .build()

            for (marketData in JSONMarketDataList) {
                barList.addBar(
                    BaseBar(
                        marketData.period,
                        marketData.endTime,
                        DecimalNum.valueOf(marketData.open),
                        DecimalNum.valueOf(marketData.high),
                        DecimalNum.valueOf(marketData.low),
                        DecimalNum.valueOf(marketData.close),
                        DecimalNum.valueOf(marketData.volume),
                        DecimalNum.valueOf(marketData.vwap)
                    )
                )

            }

            barList
        }
    }