package lib.polygon

import io.polygon.kotlin.sdk.rest.AggregatesParameters
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.MarketData
import lib.MarketDataProvider
import lib.ta4j.TA4JDataConverter
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.ExperimentalTime

/**
 * The goal of the provider is to transcribe
 * data coming from polygon into Ta4j compatible BarSeries data.
 */

interface PolygonDataProvider : MarketDataProvider {
    /**
     * This polygon lib has 4 *Clients*
     * The REST Client is the lowest level client
     *
     * EX:
     * polygonRestClient./*desiredClient*/.function()
     * polygonRestClient.stocksClient.function()
     */

    val ticker: String
    val polygonClient: PolygonRestClient

    /**
     * NOTE TO ETAN: To extrapolate on the processes of
     * 1. Getting the Polygon AggregatesDTO
     * 2. Converting it to BarSeries
     *
     *
     * We could simply just return a BarSeries from all of these functions if
     * you find no need for the MarketData Object.
     *
     * What is good about doing this, is all of our providers only need to
     * return this generic MarketData object that contains the necessary
     * values to fill out a BarSeries object.
     *
     * This will help us because all the endpoints return different data types.
     *
     * The functions for helping convert MarketData objects to BarSeries
     * are in [TA4JDataConverter] which is implemented onto the [MarketDataProvider].
     *
     */
    override fun getMarketDataForAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String,
        unadjusted: Boolean,
        limit: Long,

    ): List<MarketData> =

        smartConvertDTO(
            polygonClient.getAggregatesBlocking(
                AggregatesParameters(
                    ticker,
                    multiplier, timespan, fromDate, toDate, unadjusted, limit
            )),
            getDuration(timespan, multiplier)
        )


    private fun getDuration(timespan: String, multiplier: Long): Duration =
        when (timespan) {
            "minute" -> (1 * multiplier).minutes
            "hour" -> (1 * multiplier).hours
            "day" -> (1 * multiplier).days
            else -> throw IllegalArgumentException("Timespan not recognized")
        }

}

