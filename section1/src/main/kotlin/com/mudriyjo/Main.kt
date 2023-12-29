package com.mudriyjo

fun main(arg: Array<String>) {
    println("Hello World! arg are:${arg.fold(""){ acc, x -> "$acc $x" }}")
}