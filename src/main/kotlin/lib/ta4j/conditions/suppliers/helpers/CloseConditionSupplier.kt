package lib.ta4j.conditions.suppliers.helpers

import lib.ta4j.conditions.helpers.CloseConditions
import lib.ta4j.indicators.Close

interface CloseConditionSupplier : IndicatorConditionSupplier<Close, CloseConditions>