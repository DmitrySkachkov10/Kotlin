package operator_overloading


//если делать обычным классом, то придется переопределять equals & hashcode
data class Vector2D(val x: Double, val y: Double) {

    operator fun plus(other: Vector2D): Vector2D {
        return Vector2D(x + other.x, y + other.y)
    }

    operator fun minus(other: Vector2D): Vector2D {
        return Vector2D(x - other.x, y - other.y)
    }

}

fun main() {
    val aVector = Vector2D(2.0, 5.0)
    val bVector = Vector2D(10.0, -2.0)
    val cVector = Vector2D(10.0, -2.0)

    val sum = aVector + bVector
    println("sum of a and b vectors: ${sum}")

    val minus = aVector - bVector
    println("minus of a and b vector: ${minus}")

    println("равно ли вектора c и b? ${bVector == cVector} ")
}