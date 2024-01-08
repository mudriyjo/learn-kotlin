package org.example

fun main() {
    val list = listOf(1,2,3,4)
    val newList = list + 5
    println(list)
    println(newList)

    // List, ArrayList
    exercise1()
    println()
    exercise2()


    // Set, HashSet
    println()
    exercise3()
    println()
    exercise4()

    // Map, HashMap
    println()
    exercise5()
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
fun exercise2() {
    val animals = arrayListOf("lion", "zebra", "chimp", "elephant")
    animals.add("panda bear")

    println(animals)

    animals.remove("lion")
    println(animals)

    println("Does the zoo have both elephants and giraffes? " +
            if (animals.containsAll(listOf("elephant", "giraffe"))) "Yes" else "No"
    )
}

/*
You have a list of customers for your online store.
A new customer has joined.
Print the list of customers.
A customer has chosen to leave.
Print the list of customers.
 */
fun exercise3() {
    val customers = setOf("Alex", "May", "John", "Ben")
    val updatedCustomers = customers + "Anna"

    println(updatedCustomers)
    val newUpdatedCustomers = updatedCustomers - "Alex"

    println(newUpdatedCustomers)
}

/*
Your company has very strict dress code. Only certain color clothes can be worn in the office.
val acceptedColors = hashSetOf(“white”, “black”, “grey”)
You have certain colors in your wardrobe.
val myColors = hashSetOf(“blue”, “red”, “black”, “green”)
What color clothes can you wear.
Your company has added another color, “red” to their list. What options do you have now?
 */
fun exercise4() {
    val acceptedColors = hashSetOf("white", "black", "grey")
    val myColors = hashSetOf("blue", "red", "black", "green")
    println("I can wear: ${acceptedColors.intersect(myColors).joinToString(", ")}")

    acceptedColors.add("red")
    println("I can wear: ${acceptedColors.intersect(myColors).joinToString(", ")}")
}

/*
You manage an amusement park, and you have a map that stores dates and attendance.
var attendance = hashMapOf(Pair(“23 Sept”, 2837), Pair(“24 Sept”, 3726), Pair(“25 Sept”, 6253))
Add a value for 26 Sept.
How many people attended in total on 25 and 26 Sept?
Is data for 22 Sept available?
 */

fun exercise5() {
    val attendance = hashMapOf(Pair("23 Sept", 2837), Pair("24 Sept", 3726), Pair("25 Sept", 6253))
    attendance["26 Sept"] = 3000

    println("For 25 and 26 Sept ${(attendance["26 Sept"]?:0) + (attendance["25 Sept"]?:0)} people are attended.")

    println("Is data for 22 Sept available? ${if (attendance.containsKey("22 Sept")) "Yes" else "No"}")
}