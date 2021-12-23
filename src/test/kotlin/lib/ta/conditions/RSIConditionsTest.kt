package lib.ta.conditions

import lib.markets.polygon.PolygonDataProvider
import lib.ta.ta4j.indicators.Indicators
import lib.ta.ta4j.indicators.RSI
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.ta4j.core.BarSeries

internal class RSIConditionsTest {

    @Mock private var mockBarSeries = Mockito.mock(BarSeries::class.java)
    @Mock private var mockRSI = Mockito.mock(RSI::class.java)

    private var polygon = PolygonDataProvider("AAPL")

    @BeforeEach
    fun `Build Close Indicator`() {
        mockBarSeries = polygon.getMarketDataForAggregates(
            timespan = "minute",
            multiplier = 1,
            fromDate = "2019-01-01"
        )
        mockRSI = Indicators(mockBarSeries).rsi
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
    fun crossUnder() {
    }

    @Test
    fun pivotUp() {
    }

    @Test
    fun pivotDown() {
    }

    @Test
    fun isOver() {
    }

    @Test
    fun isUnder() {
    }
}