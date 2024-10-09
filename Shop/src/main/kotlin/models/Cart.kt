package models

class Cart {
    private val items = mutableMapOf<Product, Int>()

    fun addProduct(product: Product) {
        items[product] = items.getOrDefault(product, 0) + 1
        println("${product.name} добавлен в корзину.")

    }

    fun removeProduct(product: Product) {
        if (items.contains(product)) {
            val currentCount = items[product] ?: 0

            if (currentCount > 1) {
                items[product] = currentCount - 1
                println("Одно ${product.name} удалено из корзины. Осталось: ${currentCount - 1}.")
            } else {
                items.remove(product)
                println("${product.name} полностью удален из корзины.")
            }
        } else {
            println("Товара ${product.name} нет в корзине.")
        }
    }

    fun showCart() {
        if (!isEmpty()) {
            println("Карзина:")
            items.forEach {(product, count) ->
                val totalProductPrice = product.price * count
                println("${product.name} - x(${count}). Цена за 1шт = ${product.price}. Общая сумма: $totalProductPrice ")
            }
        } else {
            println("Корзина пуста")
        }
    }

    fun calculateTotalPrice(): Double {
        return items.entries.sumOf { (product, count) -> product.price * count }
    }

    fun clearCart() {
        items.clear()
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }
}