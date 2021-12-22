package lib.ta4j.providers.helpers

import lib.ta4j.suppliers.BarSeriesConditionSupplier
import lib.ta4j.indicators.Volume

/**
 * Override and add volume conditions.
 */
interface VolumeConditionProvider : BarSeriesConditionSupplier<Volume>