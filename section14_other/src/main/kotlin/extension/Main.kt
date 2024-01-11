package extension

fun main() {
    // Exercise 1
    val xs = arrayListOf(1,2,3,4)
    val ys = arrayListOf("Alex", "Bob", "John")
    println(xs.howManyElement())
    println(ys.howManyElement())

    println()

    // Exercise 2
    Double.printClassName()
}

/*
Add an extension function to the ArrayList class that returns a message saying how many elements the list contains.
Create an ArrayList and print out the extension function message.
 */
fun <T>ArrayList<T>.howManyElement(): Int = this.size

/*
Add a companion object function to the Double class that prints out the class name.
Call the companion object extension function.
 */
fun Double.Companion.printClassName() = println("The class name is Double")