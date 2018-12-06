package extensionfunctions

class Mumbler(var counter: Int = 0)
private fun Mumbler.incAndSay(sound: String) {
    counter++
    println(sound)
}
fun Mumbler.meow() = incAndSay("meow")
fun Mumbler.bark() = incAndSay("wuff")
fun Mumbler.stats() = println("Mumbled $counter times")

fun main(args: Array<String>) {
    val mumbler = Mumbler()
    mumbler.stats()
    mumbler.bark()
    mumbler.meow()
    mumbler.stats()
}