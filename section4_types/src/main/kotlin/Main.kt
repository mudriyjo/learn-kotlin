package org.example

fun main() {
    val number = 10
    println("variable 'number' have type : ${number::class.java} and value : $number")
    exercise()
    exercise2()
}

fun exercise() {
    println("write number")
    val number = readLine()?:"0"
    val double = 2.0
    val tmp = (number.toInt()) * double
    println("your multiplied number is: ${tmp} and have type ${tmp::class.java}")
}

fun exercise2() {
    println("write double")
    val number = readLine()?:"0.0"
    val pi = 4.14159
    val res = pi * number.toDouble()
    println("type: ${res::class.java}, value: ${res}")
}