package lib.taac4k.markets.data.io

interface ResourceSupplier {
    fun getJSONResourcePath(fileName: String): String = "/json.market_data/$fileName"
    fun getJSONResourceAsString(path: String): String =
        String(
            this::class.java.getResource(path)?.readBytes()
                ?: throw IllegalArgumentException("Path not recognized for resource $path")
        )
}