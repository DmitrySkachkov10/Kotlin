package data_classes

data class Person(val lastName: String, val firstName: String, var age: Int) {

    var smth: Smth? = null

    constructor(lastName: String, firstName: String, age: Int, smth: Smth?) : this(lastName, firstName, age) {
        this.smth = smth
    }

    override fun toString(): String {
        return "Person(lastName='$lastName', firstName='$firstName', age=$age, smth=$smth)"
    }

    fun deepCopy() : Person{
        return Person(lastName, firstName, age, smth?.deepCopy())
    }

}

class Smth() {

    var firstParam: Int? = null
    var secondParam: String? = null


    constructor(firstParam: Int?, secondParam: String?) : this() {
        this.firstParam = firstParam
        this.secondParam = secondParam
    }

    constructor(firstParam: Int?) : this(firstParam, null) {
        this.firstParam = firstParam
    }

    override fun toString(): String {
        return "Smth(firstParam=$firstParam, secondParam=$secondParam)"
    }

    fun deepCopy() : Smth {
        return Smth(firstParam, secondParam)
    }

}

fun main() {
    val person1 = Person("Skachkov", "Dmitry", 20, Smth(10, "abc"))
    val person2 = person1.copy()


    println("Basic copy: ${person2.toString()}")

    val person3 = person1.deepCopy()

    println("Deep copy: ${person3.toString()}")

    //destructuring

    val (lastName, firstName, age) = person1

    println("lastName = ${lastName}, firstName = ${firstName}, age = ${age}")
}