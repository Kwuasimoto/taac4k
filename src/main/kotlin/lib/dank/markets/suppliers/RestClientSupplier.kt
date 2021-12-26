package lib.dank.markets.suppliers

interface RestClientSupplier<RestClient> : HttpClientSupplier {
    val rest: RestClient
}


