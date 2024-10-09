package genericsAndInline

inline fun <reified T> printFruitName(fruit: T) {
    if (fruit is Fruit) {
        println("Fruit name: ${fruit.name} and  Type: ${T::class.simpleName}") //без reifeid не сможем получить тип из-за стерания типов
    } else {
        println("Not a fruit. ")
    }
}

interface Box<in T> {
    fun add(item: T)
}

interface ReadBox<out T> {
    fun getItem(): T
//    fun set(item : T) //компилятор тут сразу подсветить что нельзя, PECS и тд. компилятор просто не позволит
}


open class Fruit(val name: String) {
    override fun toString(): String {
        return "Fruit(name='$name')"
    }
}

class FruitBox : Box<Fruit> {

    private val fruits = mutableListOf<Fruit>()

    override fun add(item: Fruit) {
        fruits.add(item)
    }

    fun getAll(): MutableList<Fruit> {
        return fruits
    }
}

class ReadOnlyFruitBox : ReadBox<Fruit> {

    private val fruits = mutableListOf<Fruit>(Fruit("Apple"), Fruit("Banana"))

    override fun getItem(): Fruit {
        return fruits.random()
    }

}

fun main() {
    val fruitBox: Box<Fruit> = FruitBox()
    fruitBox.add(Fruit("Orange"))


    val readOnlyBox: ReadBox<Fruit> = ReadOnlyFruitBox()
    println(readOnlyBox.getItem())

    // Пример использования reified
    printFruitName(Fruit("Apple"))
    printFruitName("not a fruit")
}