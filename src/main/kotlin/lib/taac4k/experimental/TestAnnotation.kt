package lib.taac4k.experimental
import kotlin.reflect.KClass

annotation class TestAnnotation(
    val rawIndicator: KClass<*>,
    val conditions: KClass<*>
)
