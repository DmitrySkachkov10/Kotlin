import models.Cart
import service.Store

fun main() {
    val store = Store()
    val cart = Cart()

    while (true) {
        println("\n--- МЕНЮ ---")
        println("1. Показать товары")
        println("2. Добавить товар в корзину")
        println("3. Показать корзину")
        println("4. Оформить покупку")
        println("5. Выйти")

        print("Выберите действие: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                store.showProducts()
            }
            2 -> {
                store.showProducts()
                print("Введите номер товара для добавления в корзину: ")
                val productIndex = readLine()?.toIntOrNull()
                val product = productIndex?.let { store.getProductByIndex(it) }

                if (product != null) {
                    cart.addProduct(product)
                } else {
                    println("Неверный выбор.")
                }
            }
            3 -> {
                cart.showCart()
            }
            4 -> {
                store.checkout(cart)
            }
            5 -> {
                println("Выход из программы.")
                break
            }
            else -> {
                println("Неверный ввод. Попробуйте снова.")
            }
        }
    }
}
