package lib.ta4j.conditions

import lib.polygon.PolygonDataProvider
import lib.ta4j.indicators.Volume
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries

@ExtendWith(MockitoExtension::class)
internal class VolumeConditionsTest {

    @Mock private var mockBarSeries = Mockito.mock(BarSeries::class.java)
    @Mock private var mockVolume = Mockito.mock(Volume::class.java)

    private var polygon = PolygonDataProvider("AAPL")

    @BeforeEach
    fun `Build Close Indicator`() {
        mockBarSeries = polygon.getMarketDataForAggregates(
            timespan = "minute",
            multiplier = 1,
            fromDate = "2019-01-01"
        )
        mockVolume = Volume(mockBarSeries)
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