package org.example

fun main() {
    // IF ELSE
    exercise1()
    println()
    exercise2()
    println()
    exercise3()
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