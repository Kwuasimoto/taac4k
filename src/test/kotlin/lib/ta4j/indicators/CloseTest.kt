package lib.ta4j.indicators

import lib.polygon.PolygonDataProvider
import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries

@ExtendWith(MockitoExtension::class)
internal class CloseTest {

    @Mock
    private var mockBarSeries = Mockito.mock(BarSeries::class.java)
    @Mock
    private var mockClose = Mockito.mock(Close::class.java)

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

    @Test
    fun `Check Close movingDown Condition`() {
        val alert = mockClose.checkCondition { mockClose.conditions.isFalling(it, 3) }
        assertEquals(true, alert.asBoolean)
    }

    @Test
    fun `Check Close movingUp Condition`() {
        val alert = mockClose.checkCondition { mockClose.conditions.isRising(it) }
        assertEquals(false,alert.asBoolean)
    }
}