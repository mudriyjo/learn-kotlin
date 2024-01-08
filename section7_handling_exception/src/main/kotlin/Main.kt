package org.example

fun main() {
    exercise()
}

/*
A customer will tell the program what product they want to buy.
Then, they will tell the program how many products they require.
Assume the price of the product is 9.99
What is the total?
Handle any exceptions that might occur.
 */
fun exercise() {
    val productPrice = 9.99
    print("Write product name that you want to buy: ")
    val productName: String = readln()
    var productQnt = 0
    try {
        print("Write product quantity, should be more Int and more than 0 : ")
        productQnt = readln().toInt()
        if (productQnt <= 0) {
            throw ProductQntException("Product quantity should be more than 0")
        }
        if (productName == "") {
            throw ProductNameException("Product should contains name")
        }
    } catch (e: Exception) {
        println("Your input is incorrect, ${e.localizedMessage}")
    }

    println("You buy $productQnt amount of $productName product, by $productPrice price, total is ${productQnt * productPrice}")
}

open class ProductQntException(message: String?) : Throwable(message)
open class ProductNameException(message: String?) : Throwable(message)