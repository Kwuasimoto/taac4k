package lib.taac4k.analysis.ta.conditions.cache

/**
 * ## ConditionsCache
 * Simple Pseudo Cache System for handling function recursion if necessary.
 */
interface ConditionsCache {
    /**
     * bool that defaults to false for all indicators.
     */
    var boolCache: Boolean
    /**
     * bars left value for iterating after a condition has been met to increase significance of condition event.
     */
    var barsLeftCache: Int
    /**
     * ## reset
     * sets [boolCache] back to false, and the [barsLeftCache] back to 0.
     * @return [Boolean] the stored boolCache object.
     */
    fun reset(): Boolean
}

