package operators.invokeobject

object Sum {
    operator fun invoke(a: Int, b: Int) = a + b
}

fun main(args: Array<String>) {
    println(Sum(40, 2))
}