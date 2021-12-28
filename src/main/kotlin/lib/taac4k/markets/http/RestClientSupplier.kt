package lib.taac4k.markets.http

interface RestClientSupplier<RestClient> : HttpClientSupplier {
    val rest: RestClient
}


