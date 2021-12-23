package lib.ta.conditions

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import lib.markets.polygon.PolygonDataProvider
import lib.ta.ta4j.indicators.Close
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries

@ExtendWith(MockitoExtension::class)
internal class CloseConditionsTest {

    private var mockBarSeries: BarSeries = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private var mockClose: Close = mock()

    private var polygon = PolygonDataProvider("AAPL")

    @BeforeEach
    fun `Build Close Indicator`() {
//        mockBarSeries = polygon.getMarketDataForAggregates(
//            timespan = "minute",
//            multiplier = 1,
//            fromDate = "2019-01-01"
//        )
//        mockClose = Close(mockBarSeries)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun isRising() {
//        val jsonStream = ClassLoader.getSystemResourceAsStream("data.json")
//        val arr = JSONArray(JSONTokener(jsonStream))
//        println(arr.getJSONObject(0).getDouble("close"))
        val closeCondition = CloseConditions()
        mockClose.checkCondition {
            mockClose.conditions.isRising(it)
        }
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