package enums


enum class DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    fun isWeekend(): Boolean {
        return this == SATURDAY || this == SUNDAY
    }
}

enum class SHAPE {
    CIRCLE {
        override fun area(radius: Double): Double {
            return Math.PI * radius * radius
        }
    },
    SQUARE {
        override fun area(side: Double): Double {
            return side * side
        }
    };

    abstract fun area(value: Double): Double
}


fun main() {
    for (i in DaysOfWeek.values()) {
        if (i.isWeekend()) {
            println("Cool")
        } else {
            println("Bad")
        }
    }


    println("Circle's area with radius 20 cm are: ${SHAPE.CIRCLE.area(20.0)}")
    println("SQUARE's area with side 20 cm are: ${SHAPE.SQUARE.area(20.0)}")
}