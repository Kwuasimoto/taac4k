package lib.markets.polygon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PolygonDataProviderTest {

    private val polygonDataProvider = PolygonDataProvider("AAPL")

    @Test
    fun getMarketDataForAggregates() {
        val barSeries = polygonDataProvider.getMarketDataForAggregates(
            multiplier = 1,
            timespan = "minute",
            fromDate = "2019-01-01"
        )



        assertEquals(barSeries.barCount, 5000)
        assertEquals(barSeries.name, "Lunos")
    }
}