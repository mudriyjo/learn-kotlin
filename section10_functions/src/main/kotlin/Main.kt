package org.example

fun main() {
    // FUNCTION
    exercise1()
    println()
    // FUNCTION WITH PARAMETERS
    println("cats live: ${exercise2("cats")}")
    println("dogs live: ${exercise2("dogs")}")
    println("rabbit live: ${exercise2("rabbit")}")
    println("deer live: ${exercise2("deer")}")
    println()
    // FN OVERLOADING
    exercise3(listOf("banana", "apple", "potato", "wine"), listOf(11.0, 10.2, 5.3, 54.5))
    println()
    // VARARG
    exercise4(2, "Alex", "John", "Debby")
    println()
    // LOCAL FN
    exercise5()
    println()
    // HOF
    val greetings = {name: String -> when (name.lowercase()) {
        "alex" -> "Hello, Alex"
        "john" -> "Hello, sir John"
        "dave" -> "Greetings, mon senior Dave"
        else -> "Hello dear $name"
    } }
    exercise6(listOf("Alex", "Dave", "Peter"), greetings)
    println()
    // COMMON HOF
    exercise7(listOf(100,43,11,0,-1,234))
}

/*
Design a function that asks for a user’s name. Then it asks for a user’s birth year.
Finally, it prints out a message saying the user’s name and age.
Call the function 3 times.
 */
fun exercise1() {
    for (i in 1..3) {
        print("What is your name: ")
        val name = readln()
        print("What is your age: ")
        val age = readln().toInt()
        println("$name $age")
    }
}

/*
Create a function that receives the name of an animal, and returns the estimated lifespan.
cats -> 15
dogs -> 10
rabbit -> 12
everything else -> 20
Ask the user to input an animal, then print out the estimated lifespan for that animal.
 */
fun exercise2(nameOfAnimal: String): Int {
    return when (nameOfAnimal.lowercase()) {
        "cats" -> 15
        "dogs" -> 10
        "rabbit" -> 12
        else -> 20
    }
}

/*
Create a function that takes a product name and price.
It adds 20% tax to that product and displays a message saying how much the product costs.
Overload the function so that it takes a map of products and prices, and does the same thing.
Call both functions in your program.
 */

fun exercise3(productName: String, productPrice: Double) {
    val priceWithTax = productPrice * 1.2
    println("$productName will cost ${"%.2f".format(priceWithTax)} with tax.")
}

fun exercise3(products: List<String>, productPrice: List<Double>) {
    products.zip(productPrice).forEach {exercise3(it.first, it.second)}
}

/*
Create a function that takes an integer variable “count”
and a variable number of client names.
Print out “count” hello messages for each client.
i.e. if count = 3, print out 3 hello messages for each client.
 */
fun exercise4(count: Int, vararg clientNames: String) {
    clientNames.forEach { for (i in 1..count) { println("Hello $it") } }
}

/*
Create a function that asks the user for a name until an empty string is introduced.
Create a local function that takes a name and prints a greeting.
For each name introduced, print out a greeting.
 */
fun exercise5() {
    fun greeting(name: String) {
        println("Hello $name!")
    }
    while (true) {
        print("What is your name: ")
        val name = readln()
        if (name.isEmpty()) break
        greeting(name)

    }
}

/*
Create a Higher Order Function that takes a list of client names and a lambda expression that returns a String.
It then applies the lambda expression to every client name,
 creates a new collection of the results and returns the result.
Create a lambda expression that takes a client name String and returns a personalised message.
Call the HOF and print out the result.
 */
fun exercise6(clients: List<String>, fn: (String) -> String) {
    clients.forEach{ println(fn(it)) }
}

/*
Given a collection of random integers.
If a number is odd, double it.
If a number is even, half it.
Print out a subset of the collection that has numbers greater than 25.
 */
fun exercise7(randomInt: List<Int>) {
    randomInt.map { if (it % 2 == 0) it / 2 else it * 2 }
        .filter { it > 25 }
        .forEach { (println(it)) }
}