package lib.dank.markets.http

interface RestClientSupplier<RestClient> : HttpClientSupplier {
    val rest: RestClient
}


