package lib.ta4j.indicators.conditions.suppliers.helpers

import lib.ta4j.indicators.Close
import lib.ta4j.indicators.conditions.CloseConditions
import lib.ta4j.indicators.conditions.suppliers.IndicatorConditionSupplier

/**
 * Override and add Close conditions.
 */
interface CloseConditionSupplier :
    IndicatorConditionSupplier<Close, CloseConditions>