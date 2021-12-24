package lib.ta

import lib.ta.ta4j.indicators.Indicators
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.ta4j.core.BarSeries

@ExtendWith(MockitoExtension::class)
internal class IndicatorConditionsTest {

    @BeforeAll


    @Test
    fun isRising() {
        val barSeries: BarSeries? = null
        val closeIndicator = Indicators(barSeries!!).close

        closeIndicator.checkCondition {
            closeIndicator.conditions.isRising()
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
}