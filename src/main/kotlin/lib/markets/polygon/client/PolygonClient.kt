package lib.markets.polygon.client

import io.polygon.kotlin.sdk.DefaultOkHttpClientProvider
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.markets.MarketDataClient
import okhttp3.Interceptor
import okhttp3.Response

class PolygonClient: MarketDataClient<PolygonRestClient> {
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

    override val rest:PolygonRestClient = PolygonRestClient(
        apiKey = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye",
        httpClientProvider = http
    )
}