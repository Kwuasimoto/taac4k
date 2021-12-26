package lib.dank.markets.suppliers

import io.polygon.kotlin.sdk.DefaultJvmHttpClientProvider

interface HttpClientSupplier {
    val http: DefaultJvmHttpClientProvider
}