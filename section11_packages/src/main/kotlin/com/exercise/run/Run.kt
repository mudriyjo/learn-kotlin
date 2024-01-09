package com.exercise.run

import com.exercise.client.getName

/*
Create three packages
com.exercise.hello
    Create a function sayHi that takes a client name and prints a hello message.
com.exercise.client
    Create a function getName that reads a client name, then uses the sayHi function to print a hello message.
com.exercise.run
    Call the getName function.
 */
fun main() {
    getName()
}