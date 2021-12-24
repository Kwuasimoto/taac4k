package lib.markets.polygon
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.markets.DateParser
import lib.markets.MarketData
import lib.markets.MarketDataAdapter

/**
 *   ░░░░░░░░░░
 *   ░░░░░▄▀░░░░░░░░░░░░░
 *   ░░░░█░▄██░░░░░░██▄░░
 *   ░░░█▄▀▄▄░█░░░░█░▄░█▄
 *   ░░▄▀░▀▀▀▀░░░░░░▀▀▀░░
 *   ▄▀░░░░░░░░░░░░▄░░░░░
 *   █░░░░█░░░░░░▄▄▀░░░░░
 *   █░▄▀▄░▀▀▀▀▀▀░░░▄▀▀▄░
 *   ▀▄▀░░▀▀▄▄▄▄▄(_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅_̅ () ด้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็้็็็็็ .
 *   ░▀▄░░░░░░░░░░░░░░░░░
 *   ░░█░░░░░░░░░░░░░░░░░
 */



class PolygonDataConverter(
    override val date: DateParser = PolygonDateParser()

) : MarketDataAdapter {

    override fun parsePolygonAggregatesDTO(
        /**
         * *Uses A* Relationship
         */
        aggregates: AggregatesDTO,
        params:AggregatesParameters,
        marketDataSeries: MutableList<MarketData>
    ): MutableList<MarketData> {
        for (result in aggregates.results)
            marketDataSeries.add(
                MarketData(
                    result.ticker,
                    result.open,
                    result.high,
                    result.low,
                    result.close,
                    result.volume,
                    result.timestampMillis,
                    date.parseMillis(result.timestampMillis),
                    date.parseDuration(params.timespan, params.multiplier),
                    result.volumeWeightedAveragePrice
                )
            )

        return marketDataSeries
    }
}
