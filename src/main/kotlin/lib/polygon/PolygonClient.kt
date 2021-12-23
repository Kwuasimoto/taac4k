package lib.polygon

import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.MarketDataClient

class PolygonClient: MarketDataClient() {
    val restClient: PolygonRestClient = PolygonRestClient(
        apiKey = "ZgFx6ebkngGhMAgS7jM8pJobC4NouCye",
        httpClientProvider = okHttp.client
    )
}