package lib.ta4j.indicators.conditions

import lib.ta4j.indicators.Volume
import lib.ta4j.indicators.alerts.suppliers.VolumeAlertSupplier
import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import lib.ta4j.indicators.conditions.providers.helpers.VolumeConditionsProvider
import org.ta4j.core.BarSeries

open class VolumeConditions : VolumeConditionsProvider, VolumeAlertSupplier {

    override fun isRising(indicator: Volume, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isFalling(indicator: Volume, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun crossOver(indicator: Volume, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun crossUnder(indicator: Volume, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotUp(indicator: Volume, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(indicator: Volume, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isOver(indicator: Volume, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isUnder(indicator: Volume, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }
}