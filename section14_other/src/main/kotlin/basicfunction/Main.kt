package basicfunction

import kotlin.random.Random

fun main() {
    // Exercise 1
    exercise1()
    println()

    // Exercise 2
    val store = with((Store())) {
        supply = supply.plus(listOf("jacket", "jacket", "shoe", "jacket", "shoe", "shirt", "shirt"))
        this
    }
    store.printInventory()
    println()

    // Exercise 3
    val laptop = Laptop().run {
        this.turnOff()
        this.turnOn()
        this
    }
    println()

    // Exercise 4
    val cup = Cup().apply {
        val input = readln()
        this.clientName = input.ifEmpty { "Mr.X" }
    }
    CoffeeShop.prepareCoffee(cup)
    println()

    // Exercise 5
    Car().also {
        println("Write to company log file...")
        println("Notify police department...")
    }
    println()

    // Exercise 6
    exercise6()
    println()

    // Exercise 7
    exercise7()
    println()

    // Exercise 8
    exercise8()
    println()

    // Exercise 9
    exercise9()
}

/*
Read client names from the console until the word stop is introduced.
If the string is empty, the client is null.
Print out a hello message for each client.
 */

fun exercise1() {
    val clients: ArrayList<String?> = arrayListOf()
    while (true) {
        val clientName: String = readln()
        if (clientName.lowercase() == "stop") break
        clientName.let {
            if(it.isEmpty()) {
                clients.add(null)
            }  else {
                clients.add(it)
            }
        }
    }

    clients.forEach {
        if(it == null) {
            println("Hello anonymous")
        }  else {
            println("Hello $it")
        }
    }
}

/*
A store has a supply of shoes, shirts and jackets, as well as a method to print out the inventory.
Create a variable of type store, update its stock and print out the inventory.
 */
class Store {
    var supply: List<String> = listOf()
    fun printInventory() {
        supply.groupBy { it }.forEach{ inventoryName, list -> println("$inventoryName : ${list.size} pcs.")}
    }
}

/*
A laptop has two functions, turnOn and turnOff.
To make sure it works as expected,
 every time we have a new laptop object,
 the protocol is to turn it off and then back on again.
Create a laptop object and implement the protocol.
 */


class Laptop {
    fun turnOn() {
        println("turn on laptop...")
    }

    fun turnOff() {
        println("turn off laptop...")
    }
}

/*
A coffee shop serves cups of coffee.
A cup of coffee has a client name and a method for preparing the coffee.
Read a client name from the console, then call the sellCoffee method of the coffee shop.
Create a coffee cup object, initialise it and serve it to the client.
 */

object CoffeeShop {
    fun prepareCoffee(cup: Cup) {
        println("Your coffee is ready ${cup.clientName}")
    }
}

class Cup {
    var clientName: String = "Anonymous"
}

/*
Whenever a car is built, the company logs must be updated and the police notified.
Implement this functionality in a program.
 */

class Car()

/*
Have the user introduce 10 numbers.
Print a list that contains only odd numbers and make sure to exclude the numbers 3 and 13.
 */
fun exercise6() {
    val numbers: ArrayList<Int> = arrayListOf()
    for(i in 1..10) {
        println("Write int number: ")
        val userInput = readln().toInt()
        userInput.takeIf { it % 2 != 0 }
            .takeUnless { it == 3 || it == 13 }
            ?.let { numbers.add(it) }
    }
    println(numbers)
}

/*
The classes Cat and Dog inherit from an abstract class Animal.
 The Cat class has a function purr() and the Dog class has a function bark()
A function provides a list of animals, that are randomly distributed.
Design a program that invokes each respective function of each type of Animal from the list.
 */

fun exercise7() {
    val listOfAnimals = buildList<Animal>{ for (i in 1..10)  add(getRandomCatOrDog()) }
    listOfAnimals.forEach {
        if (it is Cat) {
            it.pur()
        } else if(it is Dog) {
            it.bark()
        }
    }
}

fun getRandomCatOrDog(): Animal {
    return if(Random.nextBoolean()) {
        Dog()
    } else {
        Cat()
    }


}
abstract class Animal
class Cat: Animal() {
    fun pur() = println("Pur pur...")
}
class Dog: Animal() {
    fun bark() = println("Bark bark...")
}

/*
Define a variable message as a String. Then define a list of prime numbers.
A function takes the list of integers and randomly returns one of them. Use it to initialize the message variable with a message including the returned prime number.
Print out the message. *
* This exercise can easily be solved in a way that doesn’t use lateinit var. For the sake of practice, please use it in this case.
 */

fun exercise8() {
    lateinit var message: String
    val listOfPrimeNumber:List<Int> = listOf(2,3,5,7,11)
    message = "prime number is : ${listOfPrimeNumber.random()}"
    println(message)
}

/*
An object of a class NewUser is created for each new user. It contains a function to print a welcome message.
In your program, you have a list of banned usernames.
Ask the user to input their desired username.
If it is not part of the list, create the NewUser object and print the welcome message.
 */

fun exercise9() {
    val banedUser = listOf("Alex", "John", "Peter")
    val newUser: NewUser by lazy { NewUser() }
    while (true) {
        print("Write user name: ")
        val userName = readln()
        if(!banedUser.contains(userName)) {
            newUser.welcomeMessage(userName)
            break
        }
        println("User already exist!")
    }
}
class NewUser() {
    fun welcomeMessage(name: String) = println("Greetings $name!!!")
}