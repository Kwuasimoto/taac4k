package lib.dank.analysis.ta

import com.nhaarman.mockitokotlin2.mock
import io.polygon.kotlin.sdk.rest.AggregatesDTO
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import lib.dank.markets.MarketDataJSON
import lib.dank.markets.polygon.PolygonDataProvider
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
internal class IndicatorConditionsTest {

    private val aggregatesParameters: AggregatesParameters = AggregatesParameters(
        "AAPL",
        1,
        "minute",
        "2019-01-01",
        "2020-01-01",
        true
    )

    private val aggregatesDTO: AggregatesDTO = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    private val marketDataJSONList: MutableList<MarketDataJSON> = mock()

    @BeforeAll
    fun setUp() {


    }

    @Test
    fun getBarCount() {
    }

    @Test
    fun percentChanged() {
    }

    @Test
    fun isRising() {
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