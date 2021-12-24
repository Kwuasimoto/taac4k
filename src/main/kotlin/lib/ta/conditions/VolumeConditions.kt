package lib.ta.conditions

import lib.ta.IndicatorConditions
import lib.ta.ta4j.indicators.helpers.Volume
import lib.ta.ta4j.conditions.providers.VolumeConditionsProvider

class VolumeConditions : IndicatorConditions<Volume>(), VolumeConditionsProvider