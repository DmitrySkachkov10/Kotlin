package service

import models.Cart
import models.Product

class Store {
    private val products = listOf(
        Product("Apple", 1.0, "Fruit"),
        Product("Banana", 0.5, "Fruit"),
        Product("Orange", 0.8, "Fruit"),
        Product("Milk", 2.0, "Milk"),
        Product("Bread", 1.5, "Baking")
    )

    fun showProducts() {
        products.forEachIndexed { index, product ->
            println("${index + 1}. Name: ${product.name}, Price: ${product.price}, Category: ${product.category}")
        }
    }

    fun getProductByIndex(index: Int): Product? {
        return products.getOrNull(index - 1)
    }

    fun checkout(cart: Cart) {
        if (cart.isEmpty()) {
            println("Корзина пуста. Невозможно оформить покупку.")
        } else {
            println("Покупка совершена. Сумма: ${cart.calculateTotalPrice()}")
            cart.clearCart()
        }
    }
}