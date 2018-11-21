
# Kotlin ~bad~ weird code collection


Kotlin is very powerful. With great power comes great responsibility.
Please don't abuse it, _we don't need another scala and perl*_


Some examples:


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




### ..and most importantly

*Remember* - we write code not for processor but for our colleagues and businesses.
Otherwise we could use asm.

-------------------

Originally published at [ruXlab/absurd-kotlin](https://github.com/ruXlab/absurd-kotlin), inspired by [twitter thread](https://twitter.com/kotlin/status/1065264275030228993)


**Disclaimer**

* Please use tool which helps to resolve daily needs for your company in a way it works for you
* Don't associate yourself with particular language or technology, you're The Human.
* _* no offence to scala and perl devs, some of us have a hard time reading that code`_