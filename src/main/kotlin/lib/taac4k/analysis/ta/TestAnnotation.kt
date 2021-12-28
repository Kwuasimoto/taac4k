package lib.taac4k.analysis.ta
import kotlin.reflect.KClass

annotation class TestAnnotation(
    val rawIndicator: KClass<*>,
    val conditions: KClass<*>
)
