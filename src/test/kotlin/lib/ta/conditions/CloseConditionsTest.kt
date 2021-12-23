package lib.ta.conditions

import lib.markets.polygon.PolygonDataProvider
import lib.ta.ta4j.indicators.Close
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries

@ExtendWith(MockitoExtension::class)
internal class CloseConditionsTest {

    @Mock private var mockBarSeries = Mockito.mock(BarSeries::class.java)
    @Mock private var mockClose = Mockito.mock(Close::class.java)

    private var polygon = PolygonDataProvider("AAPL")

    @BeforeEach
    fun `Build Close Indicator`() {
        mockBarSeries = polygon.getMarketDataForAggregates(
            timespan = "minute",
            multiplier = 1,
            fromDate = "2019-01-01"
        )
        mockClose = Close(mockBarSeries)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun isRising() {
    }

    @Test
    fun isFalling() {
    }

    @Test
    fun crossOver() {
    }

    @Test
    fun isOver() {
    }

    @Test
    fun isUnder() {
    }

    @Test
    fun crossUnder() {
    }

    @Test
    fun pivotUp() {
    }

    @Test
    fun pivotDown() {
    }
}