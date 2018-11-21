package repeat.map


operator fun <T> Int.times(f: (index: Int) -> T): List<T> {
    return 1.rangeTo(this).map { f(it) }
}

operator fun <T> ((index: Int) -> T).times(times: Int): List<T> {
    return 1.rangeTo(times).map { this(it) }
}

fun main(args: Array<String>) {
    println( (3 * { "kotlin #$it"}).joinToString(", "))
    println( ({ it: Int  -> "wow #$it"} * 3).joinToString(", "))
}

