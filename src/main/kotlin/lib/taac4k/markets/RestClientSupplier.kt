package lib.taac4k.markets

/**
 * @version 0.0.1
 * Supply a type T Rest client to a market data rest api.
 */
interface RestClientSupplier<T>  {
    val rest: T
}


