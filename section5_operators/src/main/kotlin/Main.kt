package org.example

import kotlin.math.pow

fun main() {
    exercise()
    excercis2()
}

fun exercise() {
    println("write amount that you have in your bank account")
    val interestRatePercentage = 5.5
    val year = 5
    val amount = readln()?:"0"
    println("After $year years, with interest rate $interestRatePercentage%," +
            " you will have ${(1 + (interestRatePercentage / 100)).pow(year) * amount.toDouble()}" +
            " amount in your bank account")
}

fun excercis2() {
    /*
    A farmer has 3 cows, of which only one produces milk
    He has two children
    He is trying to apply for funding. The requirements are
        You must have no more than 5 animals
        Animals must produce something that can be sold
        Regardless of the other conditions, funding will be approved if the family has 3 or more members
    Does the farmer receive the funding?
     */
    val farmersCows = 3
    val farmersCowsProduceMilk = true
    val farmersKids = 2
    println("funding is ${if (farmersCows < 6 && farmersCowsProduceMilk && farmersKids + 1 >= 3) "approved" else "not approved"}")
}