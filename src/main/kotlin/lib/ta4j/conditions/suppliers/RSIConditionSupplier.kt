package lib.ta4j.conditions.suppliers

import lib.ta4j.conditions.RSIConditions
import lib.ta4j.conditions.suppliers.helpers.IndicatorConditionSupplier
import lib.ta4j.indicators.RSI

interface RSIConditionSupplier : IndicatorConditionSupplier<RSI, RSIConditions>