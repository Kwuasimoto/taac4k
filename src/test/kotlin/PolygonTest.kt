import lib.polygon.PolygonDataProvider
import lib.ta4j.util.MovingAverageConditions
import lib.ta4j.TA4JBooleanProvider
import org.junit.jupiter.api.Test

class PolygonTest {


    private val polygonClient = PolygonDataProvider("AAPL")
    private val indicator = TA4JBooleanProvider()
    /**
     * Test if testClient is building the correct number of minute bars.
     */
    @Test
    fun `TDank's Fun Zone` () {

        // ------------- USAGE -------------

        // --- GET BARSERIES ---
        // This returns the same result set every time.
        val resultSet = polygonClient.getMarketDataForAggregates(
            multiplier = 1,
            timespan = "minute",
            fromDate = "2019-01-01",
            toDate = "2020-01-01"
        )

        // --- PERFORM TA ---
        val boolSupp = indicator.macd(
            resultSet,
            MovingAverageConditions.OVER
        )
    }

}