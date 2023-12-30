package org.example

fun main() {
    val herName: String = "Lilly"
    val hisName: String? = null
    println(herName)
    println(hisName)

    var catName: String? = "Fluffy"
    println(catName?.length)
    catName = null
    println(catName?.length)

    exercise()
    excercise2()
}

fun exercise() {
    println("write double number")
    val double = readLine()
    println("length of number multiplied by 7 is: ${double?.toDouble()?.times(7)?.toString()?.length}")
}

fun excercise2() {
    val productCost = 29.99
    println("how many product do you want toy buy?")
    val numberOfProducts = readLine()?:"1"
    println("total purchase are, $numberOfProducts products, total cost is: ${productCost * numberOfProducts.toInt()}")
}