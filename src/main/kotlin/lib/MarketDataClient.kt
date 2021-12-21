package lib

/**
 * I figured since we'll probably rarely switch out the actual
 * HttpClient (okHttp), it's okay to use is a relationship here.
 */

abstract class MarketDataClient(
    protected val okHttp: OKHttp = OKHttp()
)