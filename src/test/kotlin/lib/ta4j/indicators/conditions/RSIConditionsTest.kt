package lib.ta4j.indicators.conditions

import com.nhaarman.mockitokotlin2.mock
import lib.polygon.PolygonDataProvider
import lib.ta4j.indicators.Indicators
import lib.ta4j.indicators.RSI
import lib.ta4j.indicators.Volume
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
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