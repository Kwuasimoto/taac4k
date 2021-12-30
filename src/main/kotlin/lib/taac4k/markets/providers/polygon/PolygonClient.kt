package lib.taac4k.markets.providers.polygon

import io.polygon.kotlin.sdk.DefaultOkHttpClientProvider
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.taac4k.markets.RestClientSupplier
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Polygon rest client wrapper
 * @version 0.0.1
 *
 * @param apiKey the apiKey for the polygon client
 * @param apiDomain overridable polygon api domain
 */
class PolygonClient(apiKey: String = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye", apiDomain: String = "api.polygon.io") :
    RestClientSupplier<PolygonRestClient> {
    /**
     * Polygon rest client
     *
     * Uses a [DefaultOkHttpClientProvider] to supply a OKHttp client to [PolygonRestClient]
     */
    override val rest: PolygonRestClient = PolygonRestClient(
        apiKey,
        DefaultOkHttpClientProvider(
            applicationInterceptors = listOf(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    println("Intercepting application level")
                    return chain.proceed(chain.request())
                }
            }),
            networkInterceptors = listOf(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    println("Intercepting network level")
                    return chain.proceed(chain.request())
                }
            })
        ),
        apiDomain
    )
}