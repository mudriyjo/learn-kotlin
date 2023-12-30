package org.example

fun main() {
    printCatsNamePrinting()
    printTwoTypeOfSlashes()
    printUrl()
    exercise()

    val client = "Mary"
    val products = 3
    val price = 30
    printTotalValue(client, products, price)
}

fun printCatsNamePrinting() {
    val text = "My cat's name is \"Fluffy\""
    println(text)
}

fun printTwoTypeOfSlashes() {
    val text = "Two types of slashes: \\ and /"
    println(text)
}

fun printUrl() {
    val text = "http://google.com"
    println(text)
}

fun exercise() {
    println("(\\(\\")
    println("(-.-)")
    println("o_(\")(\")")
}

fun printTotalValue(clientName: String, productCnt: Int, price: Int){
    println("${clientName} need to pay ${productCnt * price} dollars")
}