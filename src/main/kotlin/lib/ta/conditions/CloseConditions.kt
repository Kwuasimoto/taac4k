package lib.ta.conditions

import lib.ta.IndicatorConditions
import lib.ta.ta4j.conditions.providers.CloseConditionsProvider
import org.ta4j.core.Indicator


open class CloseConditions(indicator: Indicator<*>) :
    IndicatorConditions(indicator), CloseConditionsProvider


