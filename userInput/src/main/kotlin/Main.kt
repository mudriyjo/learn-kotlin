package org.example

import java.time.LocalDate

fun main() {
    println("Hello, what is you name?")
    val name = readLine()
    println("Hello $name")

    println("How old are you?")
    val years = readLine()?:"0"
    println("You are ${years} years old")

    println("When you birth date?")
    val birthDate = readLine()?: "2000"
    printHowOldAreYou(birthDate.toInt())
}

fun printHowOldAreYou(birthDate: Int) {
    println("You are ${LocalDate.now().year - birthDate}years old")
}