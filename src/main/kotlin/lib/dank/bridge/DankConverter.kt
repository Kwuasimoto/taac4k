package lib.dank.bridge

import lib.dank.analysis.ta.ta4j.TA4JAdapter
import lib.dank.markets.polygon.PolygonDataAdapter

/**
 * Convert [@MarketData] to be compatible with [@Conditions] and [@Analysis]
 */
open class DankConverter(
    val polygonAdapter: PolygonDataAdapter = PolygonDataAdapter(),
    val ta4jAdapter: TA4JAdapter = TA4JAdapter()
)