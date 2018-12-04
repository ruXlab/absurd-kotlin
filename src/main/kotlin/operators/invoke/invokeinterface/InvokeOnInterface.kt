package operators.invoke.invokeinterface

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
