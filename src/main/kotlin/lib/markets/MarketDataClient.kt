package lib.markets

import io.polygon.kotlin.sdk.DefaultJvmHttpClientProvider

/**
 * I figured since we'll probably rarely switch out the actual
 * HttpClient (okHttp), it's okay to use is a relationship here.
 */

interface MarketDataClient<T> {
    val http: DefaultJvmHttpClientProvider
    val rest: T
}
