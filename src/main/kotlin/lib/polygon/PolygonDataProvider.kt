package lib.polygon

import io.polygon.kotlin.sdk.DefaultOkHttpClientProvider
import io.polygon.kotlin.sdk.HttpClientProvider
import io.polygon.kotlin.sdk.rest.AggregatesParameters
import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.IMarketDataProvider
import lib.ta4j.TA4JPolygonBarBuilder
import okhttp3.Interceptor
import okhttp3.Response
import org.ta4j.core.BarSeries
import org.ta4j.core.num.DoubleNum
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class PolygonDataProvider (
    private val ticker: String,

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

    private val polygonClient: PolygonRestClient = PolygonRestClient(
        apiKey = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye",
        httpClientProvider = okHttpClientProvider
    )
): TA4JPolygonBarBuilder(), IMarketDataProvider {

    override fun getMarketDataForAggregates(
        multiplier: Long,
        timespan: String,
        fromDate: String,
        toDate: String,
        unadjusted: Boolean,
        limit: Long,
    ): BarSeries = convertPolygonAggregatesDTO(this.polygonClient,
            AggregatesParameters(
                ticker = this.ticker,
                multiplier, timespan, fromDate, toDate, unadjusted, limit
        ))

}

