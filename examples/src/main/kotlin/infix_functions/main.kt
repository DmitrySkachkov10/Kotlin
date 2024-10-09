package infix_functions

data class Point(var x: Int, var y: Int)

class Offset(val x: Int, val y: Int)

infix fun Point.moveTo(offset: Offset) {
    this.x += offset.x
    this.y += offset.y
}

fun main() {
    val point = Point(5,5)
    val offset = Offset(3,-3)
    point moveTo offset
    println(point)
}

