package lib.ta4j.providers.helpers

import lib.ta4j.suppliers.BarSeriesConditionSupplier
import lib.ta4j.indicators.Close

/**
 * Override and add Close conditions.
 */
interface CloseConditionProvider : BarSeriesConditionSupplier<Close>