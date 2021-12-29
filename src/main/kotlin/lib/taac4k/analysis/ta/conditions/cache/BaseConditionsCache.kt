package lib.taac4k.analysis.ta.conditions.cache

class BaseConditionsCache : ConditionsCache {
    override var boolCache: Boolean = false
    override var barsLeftCache: Int = 0

    override fun reset(): Boolean {
        val temp = this.boolCache
        this.boolCache = false
        this.barsLeftCache = 0
        return temp
    }
}