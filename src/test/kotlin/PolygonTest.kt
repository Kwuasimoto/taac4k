import lib.polygon.PolygonDataProvider
import lib.ta4j.indicators.Close
import lib.ta4j.indicators.Indicators
import lib.ta4j.indicators.conditions.CloseConditions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeries


class PolygonTest {
    private val polygonClient = PolygonDataProvider("AAPL")

    private var mockBarSeries: BarSeries = BaseBarSeries()

    /**
     * Test if testClient is building the correct number of minute bars.
     */
    @BeforeAll
    fun `Setup` () {
        // ------------- USAGE -------------


        mockBarSeries = Mockito.mock(Indicators(BarSeries))
    }



    @Test
    fun `TDank's Fun Zone`() {

        val close = Close(barSeries)
        val allIndicators = Indicators(barSeries)

        allIndicators.close.checkCondition {
            allIndicators.close.conditions.movingUp(it)
        }

        val conditions = CloseConditions()

        println("")
        // --- PERFORM TA ---
        val result = close.checkCondition {
            println(it)

            conditions.movingDown(it, 2)
        }

        println(result)


        /** Or,
        val close = Close(barSeries)
        val closeConditions = close.conditions OR closeConditions()

        close.checkCondition {
        closeConditions.movingUp(it)
        }
         */
    }
}