package functional_interfaces

fun interface Operation {
    fun execute(x: Int, y: Int): Int
}

fun main() {

    val addition = object : Operation {
        override fun execute(x: Int, y: Int): Int {
            return x + y
        }
    }

    val substitution: Operation = Operation { x, y -> x - y }

    println(performOperation(10, 20, addition))
    println(performOperation(20, 30, substitution))

    val function = getOperator("+")

    println(performOperation(10, 20, function))


}

fun performOperation(x: Int, y: Int, operation: Operation): Int {
    return operation.execute(x, y)
}

fun getOperator(operator: String): (Int, Int) -> Int {
    return when (operator) {
        "+" -> { a, b -> a + b }
        "-" -> { a, b -> a - b }
        //etc
        else -> throw RuntimeException("Unsupported operator")
    }
}