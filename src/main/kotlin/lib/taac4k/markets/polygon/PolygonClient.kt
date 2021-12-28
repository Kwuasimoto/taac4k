package lib.taac4k.markets.polygon

import io.polygon.kotlin.sdk.DefaultOkHttpClientProvider
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.taac4k.markets.http.HttpClientSupplier
import lib.taac4k.markets.http.RestClientSupplier
import okhttp3.Interceptor
import okhttp3.Response

class PolygonClient(apiKey: String = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye", apiDomain: String = "api.polygon.io") :
    RestClientSupplier<PolygonRestClient>, HttpClientSupplier {

    override val http = DefaultOkHttpClientProvider(
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
    )

    override val rest: PolygonRestClient = PolygonRestClient(
        apiKey,
        http,
        apiDomain
    )
}