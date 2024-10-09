package collections

import java.util.*

fun main() {
    //создани List

    val numberSet = setOf("one", "two")
    val emptySet = mutableSetOf<String>()

    val numbersMap = mutableMapOf<String, Int>("one" to 1, "two" to 2)


    //более правильный вариант, ибо to создает Pair каждый раз и это плохо для производительности
    val numberMap2 = mutableMapOf<String, Int>()
        .apply {
            this["one"] = 1;
            this["second"] = 2
        }


    val list = listOf(1, 2, 3)

    // тут вот это вызывается
    // public inline fun <T> List(size: Int, init: (index: Int) -> T): List<T> = MutableList(size, init)
    val doubled = List(3, { it * 2 })
    println(doubled) // 0, 2, 4


    val linkedList = LinkedList<Int>(listOf(20, 30, 40))


    //копирование нормалное
    val sourceList = mutableListOf(1, 2, 3)
    val copyList = sourceList.toMutableList()
    copyList.add(3, 5)
    copyList.add(10)

    println("copyList: $copyList. SourceList: $sourceList")


    val linkCopy = sourceList
    linkCopy.removeAt(0)

    println(sourceList) //видно что удаляя там, мы удаляем и тут. потому что ссылка)

    //но можно скопировать в immutable
    val immutableList: List<Int> = sourceList
    //immutableList.add(2) все ошибка. IDE сразу укажет на это


    //associateWith()
    //fun <T, V> Iterable<T>.associateWith(valueSelector: (T) -> V): Map<T, V>

    val map = sourceList.associateWith { (it + 5) * 2 }
    println("map: $map")


}
