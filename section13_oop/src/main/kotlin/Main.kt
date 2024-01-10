package org.example

fun main() {
    val calculator = Calculator(1.0)
    calculator.add(10.0)
    calculator.sub(5.0)
    calculator.div(3.0)
    calculator.mul(4.0)
    // Print result
    println(calculator)

    // Print result
    calculator.reset()
    println(calculator)

    // Exercise 2
    val engineer = Engineer()
    engineer.study()
    engineer.study()
    engineer.study()
    engineer.work()
    engineer.work()

    println("Profession is: ${engineer.name}, salary is: ${engineer.salary}, revenue is: ${engineer.revenue}")

    val doctor = Doctor()
    doctor.work()
    doctor.work()
    doctor.work()
    doctor.work()

    println("Profession is: ${doctor.name}, salary is: ${doctor.salary}, revenue is: ${doctor.revenue}")

    // Exercise 3
    OnlineStore("Alex", 200)

    //Exercise 4
    val bank = Bank()
    bank.amount = 3330
    println("My interest rate is: ${bank.interestRate}")

    // Exercise 5
    val table = Table(200, 200)
    table.adjustWidth(300)
    table.adjustHeight(350)
    println(table)

    // Exercise 6
    WebBrowser("localhost")

    // Exercise 7
    val book = Book(Book.getEditor())
    println("Book editor is: ${book.editor.name}")
}

/*
Create a calculator class. It should have
A variable that stores the total
A function that adds a number to the total
A function that subtracts a number from the total
A function that multiplies the total by an amount
A function that divides the total by an amount
A function that resets the total to 0
Create an object, test out the functions and print out some results.
 */
class Calculator(private var total: Double = 0.0) {
    fun add(number: Double) {
        total += number
    }

    fun sub(number: Double) {
        total -= number
    }

    fun mul(number: Double) {
        total *= number
    }

    fun div(number: Double) {
        total /= number
    }

    fun reset() {
        total = 0.0
    }

    override fun toString(): String {
        return total.toString()
    }
}


/*
A class Job has three variables, name, revenue and salary, and two methods,
work - which increases revenue by the amount in salary
study - which increases salary
Two classes, Engineer and Doctor inherit from the Job class, but have different values for salary.
Create objects and call the functions a few times, printing out messages to see the result of the functions.
 */

class Engineer() : Job("Engineer", 1000, 1000)
class Doctor() : Job("Doctor", 2000, 1000)
open class Job(var name: String, var revenue: Int, var salary: Int) {
    fun work() {
        revenue += salary
    }

    fun study() {
        salary += 1000
    }
}


/*
Create an online store user account class that has a userName and balance
Create 3 constructors for this class.
Inside the constructors, based on the user balance,
 print out whether they can afford the product tshirt,
  which costs 20, and if so, how many can they afford.
 */

class OnlineStore {
    var userName: String = ""
    var balance: Int = 0

    constructor(): this("Anonymous", 1000)
    constructor(userName: String): this(userName, 1000)
    constructor(userName: String, balance: Int) {
        this.balance = balance
        this.userName = userName
        printTshirtAfford()
    }

    private fun printTshirtAfford() {
        val shirtQt = balance / 20
        if (shirtQt > 0) {
            println("You can afford $shirtQt tshirts")
        } else {
            println("You can't afford tshirt")
        }
    }
}

/*
A bank has various rules for interest rates.
If a user has less than 1000 in their account, their interest rate is 1.0
If a user has less than 10.000 in their account, their interest rate is 0.5
If a user has 10000 and over, their interest rate is 0.2.
Implement this in a program, create an object, update the amount and print out the interest rate.
 */
class Bank {
    var amount: Int = 0
        get() = field
        set(value) {
            field = value
            interestRate = if (value < 1000) {
                1.0
            } else if (value < 10_000) {
                0.5
            } else {
                0.2
            }
        }

    var interestRate: Double = 0.0
}

/*
A table allows the user to adjust the height and size,
 through a function that also takes the parameters height and size.
Create the class, variable,
 function, instantiate it and call the function to adjust height and size.
 */

class Table(private var width: Int = 100, private var height: Int = 100){
    fun adjustHeight(height: Int) {
        this.height = height
    }
    fun adjustWidth(width: Int) {
        this.width = width
    }

    override fun toString(): String {
        return "Table width: ${width}, height: ${height}"
    }
}

/*
A web browser will connect and display the home page when first started.
Create a class that achieves this functionality when instantiated.
 */

class WebBrowser(var homePage: String) {
    init {
        println("The home page is ${homePage}")
    }
}

/*
A book class will provide information about the editor without the need to be instantiated.
It will also require this information - in the form of an editor object type - in the constructor.
Implement this in a program.
 */

class Book(val editor: Editor) {
    companion object {
        fun getEditor(): Editor {
            return Editor("John")
        }
    }
}

class Editor(val name: String)