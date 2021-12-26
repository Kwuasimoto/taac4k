package lib.dank.markets.polygon

import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.MarketDataAdapter
import lib.dank.markets.MarketDataJSON
import lib.dank.markets.enums.TIMESPAN
import java.util.*

class PolygonDataAdapter(
    private val date: PolygonDateParser = PolygonDateParser()

) : MarketDataAdapter {

    override fun from(
        aggregates: AggregatesDTO,
        params: AggregatesParameters
    ): MutableList<MarketDataJSON> {
        val newMarketDataList = newList

        for (aggregate in aggregates.results)
            newMarketDataList.add(
                MarketDataJSON(
                    params.ticker,
                    aggregate.open!!,
                    aggregate.high!!,
                    aggregate.low!!,
                    aggregate.close!!,
                    aggregate.volume!!,
                    date.parseMillis(aggregate.timestampMillis),
                    date.parseDuration(
                        TIMESPAN.valueOf(params.timespan.uppercase(Locale.getDefault())),
                        params.multiplier
                    ),
                    aggregate.volumeWeightedAveragePrice!!
                )
            )

        return newMarketDataList
    }
}
