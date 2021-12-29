package lib.taac4k.analysis.ta.conditions.cache

interface ConditionsCache {
    var boolCache: Boolean
    var barsLeftCache: Int

    fun reset(): Boolean
}

