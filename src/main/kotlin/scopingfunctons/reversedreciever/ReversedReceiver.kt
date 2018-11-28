package scopingfunctons.reversedreciever


fun f1() = "f1()"
fun f2() = "f2()"
fun f3() = "f3()"

fun run(arg: String?) = mapOf("a" to ::f1, "b" to ::f2, "c" to ::f3).apply {
        arg.let { it?.trim() }
            .let { this[it] }
            ?.let { println(it()) }
    }

fun run2(arg: String?) {
    when(arg?.trim()) {
        "a" -> f1()
        "b" -> f2()
        "c" -> f3()
        else -> ""
    }.let { println(it) }
}

fun main(args: Array<String>) {
    run("a")
    run2("a")
}