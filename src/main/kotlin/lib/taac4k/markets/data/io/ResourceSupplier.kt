package lib.taac4k.markets.data.io

/**
 * Primary resource supplier for assisting with [MarketDataIO]
 * @version 0.0.1
 */
interface ResourceSupplier {
    /**
     * creates a default JSON resource path string for accessing cold data using
     *  - "/json.market_data/[fileName]"
     */
    fun getJSONResourcePath(fileName: String): String = "/json.market_data/$fileName"

    /**
     * Uses a resource [path] to fetch a JSON resource as a string
     */
    fun getJSONResourceAsString(path: String): String =
        String(
            this::class.java.getResource(path)?.readBytes()
                ?: throw IllegalArgumentException("Path not recognized for resource $path")
        )
}