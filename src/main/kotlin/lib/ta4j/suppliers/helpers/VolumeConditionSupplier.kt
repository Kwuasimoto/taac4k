package lib.ta4j.suppliers.helpers

import lib.ta4j.indicators.Volume
import lib.ta4j.providers.helpers.VolumeConditionProvider
import lib.ta4j.suppliers.ConditionAlertSupplier
import org.ta4j.core.BarSeries

class VolumeConditionSupplier : VolumeConditionProvider {
    override fun barsSince(
        indicator: Volume,
        condition: () -> ConditionAlertSupplier,
        length: Int
    ): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingUp(indicator: Volume): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingUpFor(indicator: Volume, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingDown(indicator: Volume): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun movingDownFor(indicator: Volume, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun crossOver(
        indicator: Volume,
        barSeries: BarSeries,
        barIndex: Int,
        length: Int
    ): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun crossUnder(
        indicator: Volume,
        barSeries: BarSeries,
        barIndex: Int,
        length: Int
    ): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun pivotUp(indicator: Volume, checkFrom: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun pivotDown(indicator: Volume, checkFrom: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun isOver(indicator: Volume, barSeries: BarSeries, barIndex: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun isUnder(indicator: Volume, barSeries: BarSeries, barIndex: Int, length: Int): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun bullishDivergence(indicator: Volume): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun hiddenBullishDivergence(indicator: Volume): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun bearishDivergence(indicator: Volume): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }

    override fun hiddenBearishDivergence(indicator: Volume): ConditionAlertSupplier {
        TODO("Not yet implemented")
    }
}