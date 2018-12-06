
# Kotlin ~bad~ weird code collection


Kotlin is very powerful. With great power comes great responsibility.

Please don't abuse it, _we don't need another scala and perl*_


## Repeat

### Repeat with overloaded operator

```kotlin
3 * { println("kotlin rocks") }
```

Output:

```
kotlin rocks
kotlin rocks
kotlin rocks
```

### Map function on closure

```kotlin
fun main(args: Array<String>) {
    println( (3 * { "kotlin #$it"}).joinToString(", "))
    println( ({ it: Int  -> "wow #$it"} * 3).joinToString(", "))
}
```

Output:

```
kotlin #1, kotlin #2, kotlin #3
wow #1, wow #2, wow #3
```


## Abusing kotlin scoping functions

### What is `this`?

Say, we've got number of processors for different inputs, mappings are finite and no dynamic. 

```kotlin
fun run(arg: String?) = mapOf("a" to ::f1, "b" to ::f2, "c" to ::f3).apply {
        arg.let { it?.trim() }
            .let { this[it] }
            ?.let { println(it()) }
    }
```

How does it feel after quick look on snippet above? It's very easy to get lost while scanning code

## Operator overloading abuse

We have learnt from c++ that operators overloading should be used with a great care.
Misuse might confuse your fellow colleague and even yourself  

### Invoke on object

Object are meant to be [singleton-like object](https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations) or 
used as a place for factory methods.


```kotlin
object Sum {
    operator fun invoke(a: Int, b: Int) = a + b
}

fun main(args: Array<String>) {
    println(Sum(40, 2))
}
```
It is possible to use object with overloaded invoke operator as a function, but
why would someone use it instead of higher order functions? 
  

### Invoke on self-constructing interface

Why would you use interfaces as a classes, simulating constructor by using `invoke`?

```kotlin
interface Person {
    val firstName: String
    val lastName: String

    companion object {
        operator fun invoke(firstName: String, lastName: String): Person {
            return object : Person {
                override val firstName: String = firstName
                override val lastName: String = lastName
                override fun toString(): String = "$firstName $lastName"
            }
        }
        val NONAME = this("NO NAME", "")
    }
}

fun main(args: Array<String>) {
    println(Person("Alex", "Popov"))
    println(Person.NONAME)
}

```

Output:

```
Alex Popov
NO NAME
```

It's kinda cool to make interface behave as a object or function but what that point?

## Extension functions

### Extension function instead of member

While code looks _almost_ the same what is the point of breaking classic encapsulation?
Extension function can serve a great deal when it comes to foreign code extension
or to tame your own for clarity  

```kotlin
package extentionfunctions

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
```

If there is no good reason to do so - just put those properties and functions 
inside the class, as it expected in OOP

### ..and most importantly
        
*Remember* - we write code not for processor but for our colleagues and businesses.
Otherwise we could use asm.

-------------------

Originally published at [ruXlab/absurd-kotlin](https://github.com/ruXlab/absurd-kotlin), inspired by [twitter thread](https://twitter.com/kotlin/status/1065264275030228993)


**Disclaimer**

* Please use tool which helps to resolve daily needs for your company in a way it works for you
* Don't associate yourself with particular language or technology, you're The Human.
* _* no offence to scala and perl devs, some of us have a hard time reading that code`_