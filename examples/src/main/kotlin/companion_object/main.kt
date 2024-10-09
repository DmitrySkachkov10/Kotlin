package companion_object

object Simple {
    fun first() {
        println("first")
    }

    fun second() {
        println("Second")
    }
}

class MainClass() {
    companion object {
        const val SOME_PROPERTY: String = "fsnfknfknfknafkna"
        fun makeFirst() {
            Simple.first()
        }

        fun makeSecond() {
            Simple.second()
        }
    }
}

fun main() {
    val a = MainClass
    a.makeFirst()
    a.makeSecond()
    println(a.SOME_PROPERTY)
}