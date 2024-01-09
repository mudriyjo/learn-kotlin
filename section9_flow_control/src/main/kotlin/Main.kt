package org.example

fun main() {
    // IF ELSE
    exercise1()
    println()
    exercise2()
    println()
    exercise3()
    println()
    // WHEN
    exercise4()
    println()
    exercise5()
    // FOR
    println()
    exercise6()
    // WHILE
    println()
    exercise7()
    println()
    exercise8()
    // BREAK
    println()
    exercise9()
}

/*
Define two variables
val hasEggs = true
val hasBacon = false
A man goes to the market. His instructions are:
If you find eggs, buy 12
If you buy eggs, and you also find bacon, buy two packs
Eggs cost 5 each.
A pack of bacon costs 20.
How much does the man spend at the market?
 */
fun exercise1() {
    val hasEggs = true
    val hasBacon = false
    var totalSpend = 0
    if (hasEggs && hasBacon) {
        totalSpend += 5 * 2 + 20
    } else if (hasEggs) {
        totalSpend += 12
    }

    println("Total spent: $totalSpend")
}


/*
You are designing a grading system for school exams.
The total for an exam is 100 points, and you need to convert that into a grade A to F.
Design a program that reads in a number that represents a student’s grade, from 1 to 100 and prints out a grade.
A -> 90 to 100
B -> 80 to 89
C -> 70 to 79
D -> 60 to 69
E -> 50 to 59
F -> everything else
 */
fun exercise2() {
 val points = 100
 val grade = if (points >= 90) "A"
    else if (points >= 80) "B"
    else if (points >= 70) "C"
    else if (points >= 60) "D"
    else if (points >= 50) "E"
    else "F"
 println("Your grade is: $grade")
}

/*
Ask a user to input their age.
If they are under 13, they are a child
If they are under 18, they are a teen
If they are older, they are an adult.
Use ranges to print out the correct message.
If the age is 0, convert it to 1.
 */
fun exercise3() {
    println("Please write your age: ")
    try {
        var age = readln().toInt()
        if (age == 0) age = 1

        if (age < 13) {
            println("You are child")
        } else if (age < 18) {
            println("You are teen")
        } else {
            println("You are adult")
        }
    } catch (e: Exception) {
        println("Can't parse input ${e.localizedMessage}")
    }
}

/*
Ask the user to input their name.
Based on the first letter of their name, print out a personalised greeting
for the first 3 letters of the alphabet,
a different one for the next 3 letters,
and a third message for the rest
 */

fun exercise4() {
    print("Write your name: ")
    val input: String = readln()
    when (input.lowercase().first()) {
        in 'a'..'c' -> { println("Hello my friend!") }
        in 'd'..'f' -> { println("Hello bro!") }
        else -> { println("Hi, how are you?") }
    }
}

/*
Ask the user to input a year. For each month of that year, print out how many days there are.
Make sure you count leap years.
Assume a leap year is a year that is divisible by 4.
*there are additional rules for leap years, but we will ignore those in this exercise
 */

fun exercise5() {
    print("Write year: ")
    val year = readln()
    val isLeapYear: Boolean = year.toInt() % 4 == 0
    for (month in 1..12) {
        when (month) {
            in listOf(1,3,5,7,8,10,12) -> {
                println("${month}st month have 31 days ")
            }
            in listOf(4,6,9,11) -> {
                println("${month}st month have 30 days ")
            }
            else -> { if (isLeapYear) println("${month}st month have 29 days") else println("${month}st month have 28 days")
            }
        }
    }
}

/*
Ask the user for a number.
Print out a square matrix of the size indicated by the number.
Inside each cell, print out 1 emoji
😀 If the row*column is divisible by 3
🤨 If the row*column % 3 is 1
😱 If the row*column % 3 is 2
 */

fun exercise6() {
    print("Write a matrix size, Int number: ")
    val matrixSize = readln().toInt()
    for (x in 1..matrixSize) {
        for (y in 1.. matrixSize) {
            if (x * y % 3 == 0 ) {
                print("\uD83D\uDE00 ")
            } else if (x * y % 3 == 1) {
                print("\uD83E\uDD28 ")
            } else {
                print("\uD83D\uDE31 ")
            }
        }
        println()
    }
}

/*
Ask the user to input a large integer.
Print out all the numbers that are divisible by 7, that are less than the user’s number.
 */

fun exercise7() {
    print("Write gin Int number: ")
    var bigNumber = readln().toInt()
    while(bigNumber > 0) {
        if (bigNumber % 7 == 0) println(bigNumber)
        bigNumber--
    }
}

/*
You have a set of usernames
val usernames = hashSetOf(“john”, “bob”, “alice”)
Ask the user to choose their username. If their username is taken, print out a message and ask again.
Add the username to the set.
 */

fun exercise8() {
    val usernames = hashSetOf("john", "bob", "alice")
    var nameIsChosen = false
    do {
        print("Choose name for character: ")
        val name = readln()
        if (usernames.contains(name)) {
            println("Name already chosen, pls choose another name")
        } else {
            usernames.add(name)
            nameIsChosen = true
        }
    } while (!nameIsChosen)

    println("Name of all characters: $usernames")
}

/*
A group of young people are going to a nightclub.
Design a program that accepts user ages.
The program displays a welcome message for each user.
If it receives an age lower than 18, it prints a message that this client is not allowed.
If it receives the word “stop”, the program ends
 */

fun exercise9() {
    val stopWord = "stop"
    do {
        print("Write your name: ")
        val nameInput = readln()
        print("Write your age: ")
        val ageInput = readln()

        if (nameInput == stopWord || ageInput == stopWord) break

        val age = ageInput.toInt()
        if (age < 18) {
            println("You can't pass to night club")
        } else {
            println("Welcome to night club!!!")
        }
    } while (true)
}