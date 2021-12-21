package lib.polygon

import io.polygon.kotlin.sdk.rest.PolygonRestClient
import lib.MarketDataClient

class PolygonClient: MarketDataClient() {
    val restClient: PolygonRestClient = PolygonRestClient(
        apiKey = "",
        httpClientProvider = okHttp.client
    )
}