package lib.ta.conditions

import lib.ta.IndicatorConditions
import lib.ta.ta4j.indicators.Close
import lib.ta.ta4j.conditions.providers.CloseConditionsProvider


open class CloseConditions : IndicatorConditions<Close>(), CloseConditionsProvider


