package lib.taac4k.markets

/**
 * ## RestClientSupplier<T>
 * Supply a type T Rest client to a market data rest api.
 * @version 0.0.1
 */
interface RestClientSupplier<T>  {
    val rest: T
}


