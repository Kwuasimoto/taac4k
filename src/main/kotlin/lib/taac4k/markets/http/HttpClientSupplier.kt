package lib.taac4k.markets.http

import io.polygon.kotlin.sdk.DefaultJvmHttpClientProvider

interface HttpClientSupplier {
    val http: DefaultJvmHttpClientProvider
}