package lib.ta.ta4j.conditions

import lib.ta.ta4j.indicators.Volume
import lib.ta.ta4j.conditions.providers.VolumeConditionsProvider

open class VolumeConditions : IndicatorConditions<Volume>(), VolumeConditionsProvider