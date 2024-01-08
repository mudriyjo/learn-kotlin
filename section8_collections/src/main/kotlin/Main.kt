package org.example

fun main() {
    val list = listOf(1,2,3,4)
    val newList = list + 5
    println(list)
    println(newList)

    exercise1()
    excercise2()
}

/*
You have a number of items on your desk.
val items = arrayListOf(“laptop”, “mouse”, “pen”, “paper”, “mug”, “phone”)
You clean up your desk and remove as many items as you can to be more productive.
val removedItems = listOf(“pen”, “paper”, “mug”, “phone”)
Print out the remaining items.
 */
fun exercise1() {
    val items = arrayListOf("laptop", "mouse", "pen", "paper", "mug", "phone")
    val removedItems = listOf("pen", "paper", "mug", "phone")
    items.removeAll(removedItems)

    println(items)
}

/*
A zoo has a list of animals.
val animals = arrayListOf(“lion”, “zebra”, “chimp”, “elephant”)
A new panda bear cub has arrived.
Print out the new list of animals.
The lion has been sold to a different zoo.
Print out the new list of animals.
Does the zoo have both elephants and giraffes?
 */
fun excercise2() {
    val animals = arrayListOf("lion", "zebra", "chimp", "elephant")
    animals.add("panda bear")

    println(animals)

    animals.remove("lion")
    println(animals)

    println("Does the zoo have both elephants and giraffes? ${if (animals.containsAll(listOf("elephant", "giraffe"))) "Yes" else "No"}")
}