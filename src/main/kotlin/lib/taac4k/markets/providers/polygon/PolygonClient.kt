package lib.taac4k.markets.providers.polygon

import io.polygon.kotlin.sdk.DefaultOkHttpClientProvider
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.taac4k.markets.RestClientSupplier
import okhttp3.Interceptor
import okhttp3.Response

class PolygonClient(apiKey: String = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye", apiDomain: String = "api.polygon.io") :
    RestClientSupplier<PolygonRestClient> {

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