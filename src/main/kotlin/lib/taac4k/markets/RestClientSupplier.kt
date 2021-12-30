package lib.taac4k.markets

/**
 * Supply a type T Rest client to a market data rest api.
 */
interface RestClientSupplier<T>  {
    val rest: T
}


