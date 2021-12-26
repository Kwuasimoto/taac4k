package lib.dank.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.polygon.kotlin.sdk.rest.AggregateDTO
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.analysis.ta.ta4j.Indicators
import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.analysis.ta.ta4j.indicators.helpers.Close
import lib.dank.bridge.DankConverter
import lib.dank.markets.io.MarketDataIO
import lib.dank.markets.data.JSONMarketData
import lib.dank.markets.polygon.PolygonDataAdapter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.ZonedDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class IndicatorConditionsTest {

    /**
     * - Market Data Raw
     */
    private val mockAggregates: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2020-01-01",
        true
    )

    private val mockConverter: DankConverter = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockIndicators: Indicators = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val mockJSONMarketDataList: MutableList<JSONMarketData> = mock()

    private val marketDataIO = MarketDataIO(jsonFileName = "market_data_576f27ac-828a-428c-b240-42da80317bf3.json")

    @BeforeAll
    fun setUp() {
        whenever(mockConverter.polygonAdapter).thenReturn(PolygonDataAdapter())
        whenever(mockConverter.ta4jAdapter).thenReturn(TA4JAdapter())

            // Get IO DATA
        val marketData = marketDataIO.toBarSeries()

        whenever(mockAggregates.results).thenReturn(
            listOf(
                AggregateDTO(
                    "AAPL",
                    1000.50,
                    55.2,
                    40.0,
                    60.0,
                    20.0,
                    80.0,
                    ZonedDateTime.now().toEpochSecond()
                ),
                AggregateDTO(
                    "AAPL",
                    800.50,
                    51.2,
                    35.0,
                    55.0,
                    18.0,
                    75.0,
                    ZonedDateTime.now().toEpochSecond()
                )
            )
        )

        /**
         * Convert Data
         */
        val convertedMockData = mockConverter.polygonAdapter.from(
            mockAggregates,
            mockParameters
        )

        whenever(mockJSONMarketDataList[0]).thenReturn(convertedMockData[0])
        whenever(mockJSONMarketDataList[1]).thenReturn(convertedMockData[1])
    }

    @Test
    fun indicatorsInstantiation() {
        val data = mockConverter.polygonAdapter.from(
            mockAggregates,
            mockParameters
        )

        assertEquals(mockIndicators.close::class.java, Close(data)::class.java)
    }

    @Test
    fun conditionsInstantiations() {
        //assertEquals(mockIndicators.close.conditions::class.java, )
    }

    @Test
    fun isRising() {
        val data = mockConverter.polygonAdapter.from(
            mockAggregates,
            mockParameters
        )

        whenever(mockIndicators.close).thenReturn(Close(data))

        whenever(mockIndicators.close.checkConditionZoned {
            mockIndicators.close.conditions.isRising()
        }).then {
            "Mock called with arguments: " + it.arguments
        }
    }

    @Test
    fun isFalling() {
    }

    @Test
    fun isOver() {
    }

    @Test
    fun isUnder() {
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
    fun getMarketDataList() {
    }
}

//        whenever(mockBarSeries.getBar(0).openPrice.doubleValue()).thenReturn(40.0)
//        whenever(mockBarSeries.getBar(0).closePrice.doubleValue()).thenReturn(60.0)
//        whenever(mockBarSeries.getBar(0).lowPrice.doubleValue()).thenReturn(20.0)
//        whenever(mockBarSeries.getBar(0).highPrice.doubleValue()).thenReturn(80.0)
//        whenever(mockBarSeries.getBar(0).volume.doubleValue()).thenReturn(1000.50)
//        whenever(mockBarSeries.getBar(0).amount.doubleValue()).thenReturn(55.2)
