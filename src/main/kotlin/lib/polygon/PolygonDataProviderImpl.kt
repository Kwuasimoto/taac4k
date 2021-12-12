package lib.polygon

import io.polygon.kotlin.sdk.DefaultOkHttpClientProvider
import io.polygon.kotlin.sdk.HttpClientProvider
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Polygon DataProvider Implementation
 *
 * Overrides Ticker param on all paramObjects [ex: AggregatesParameters]
 *  for Outgoing requests to Polygon.
 */
class PolygonDataProviderImpl(

    override val ticker: String,

    /***
     * Defaults
     */
    private val okHttpClientProvider: HttpClientProvider = DefaultOkHttpClientProvider(
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

    override val polygonClient: PolygonRestClient = PolygonRestClient(
        // ByBit testnet key, if you find this, go ham :)
        apiKey = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye",
        httpClientProvider = okHttpClientProvider
    )

) : PolygonDataProvider
