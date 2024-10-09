package null_safety_and_extensions

import java.lang.RuntimeException

class User(val name: String, var age: Int, var email: String? = null) {

    /*
    В идеале, использовать своё кастомное исключение. Оставлю так просто ради примера и экономии времени
    */
    fun getMail(): String {
        return email ?: throw RuntimeException("No email")
    }

    override fun toString(): String {
        return "Пользователь: '$name', возраст: $age, почта: ${email ?: "Не указано"}"
    }

}

fun User.incrementAge() {
    this.age += 1
}

fun main() {
    val user1 = User("Dmitry", 20)
    val user2 = User("Max", 21, "test@gmail.com")

    try {
        println("User email: ${user2.getMail()}")
        println("User email: ${user1.getMail()}")
    } catch (e: RuntimeException) {
        println(e.message)
    }

    user1.incrementAge()
    user2.incrementAge()

    println(user1.toString())
    println(user2.toString())
}