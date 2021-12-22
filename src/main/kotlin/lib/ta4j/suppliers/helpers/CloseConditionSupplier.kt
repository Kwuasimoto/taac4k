package lib.ta4j.suppliers.helpers

import lib.ta4j.indicators.Close
import lib.ta4j.providers.helpers.CloseConditionProvider
import lib.ta4j.suppliers.ConditionAlertSupplier
import org.ta4j.core.BarSeries

class CloseConditionSupplier : CloseConditionProvider {

    override fun barsSince(
        indicator: Close,
        condition: () -> ConditionAlertSupplier,
        length: Int
    ): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingUp(indicator: Close): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingUpFor(indicator: Close, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingDown(indicator: Close): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingDownFor(indicator: Close, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun crossOver(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun crossUnder(
        indicator: Close,
        barSeries: BarSeries,
        barIndex: Int,
        length: Int
    ): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun pivotUp(indicator: Close, checkFrom: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun pivotDown(indicator: Close, checkFrom: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun isOver(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(indicator: Close, barSeries: BarSeries, barIndex: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun bullishDivergence(indicator: Close): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun hiddenBullishDivergence(indicator: Close): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun bearishDivergence(indicator: Close): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun hiddenBearishDivergence(indicator: Close): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }
}