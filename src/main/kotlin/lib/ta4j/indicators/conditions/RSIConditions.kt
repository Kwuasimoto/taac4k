package lib.ta4j.indicators.conditions

import lib.ta4j.indicators.RSI
import lib.ta4j.indicators.alerts.suppliers.RSIAlertSupplier
import lib.ta4j.indicators.alerts.suppliers.ZonedAlert
import lib.ta4j.indicators.conditions.providers.RSIConditionProvider
import org.ta4j.core.BarSeries

class RSIConditions :RSIConditionProvider, RSIAlertSupplier {


    override fun isRising(indicator: RSI, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isFalling(indicator: RSI, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun crossOver(indicator: RSI, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun crossUnder(indicator: RSI, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotUp(indicator: RSI, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun pivotDown(indicator: RSI, checkFrom: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isOver(indicator: RSI, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }

    override fun isUnder(indicator: RSI, barSeries: BarSeries, barIndex: Int, length: Int): ZonedAlert {
        TODO("Not yet implemented")
    }
}