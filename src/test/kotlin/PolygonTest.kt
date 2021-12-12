import lib.polygon.PolygonDataProviderImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PolygonTest {


    private val polygonClient = PolygonDataProviderImpl("AAPL")
    /**
     * Test if testClient is building the correct number of minute bars.
     */
    @Test
    fun `Test Polygon Client Impl` () {

        // This returns the same result set every time.
        val resultSet = polygonClient.getMarketDataForAggregates(
            multiplier = 1,
            timespan = "minute",
            fromDate = "2019-01-01"
        )



        assertEquals(resultSet.size, 5000)
    }

}