package com.exercise.client

import com.exercise.hello.sayHi

//Create a function getName that reads a client name, then uses the sayHi function to print a hello message.
fun getName() {
    print("Write your name: ")
    val name = readln()
    sayHi(name)
}