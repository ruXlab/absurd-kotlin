package repeat.loop


/**
 * Found here https://twitter.com/alwynschoeman/status/1065352265475739649
 * @author @alwynschoeman
 */

operator fun Int.times(f: (index: Int) -> Unit) {
    for(i in 1..this) f(i)
}


fun main(args: Array<String>) {
    3 * { println("kotlin rocks $it") }
}

