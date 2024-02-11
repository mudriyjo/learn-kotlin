package org.example

import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
//    coroutineHelloWord()
//    coroutineScope()
//    coroutineContext()
//    runBlocking {
//        launch {
//            functionCount()
//        }
//    }
//    jobs()
    dispatcher()
    asyncCoroutine()

    runBlocking {
        launch {
            errorHandlingFunction()
        }
    }
}
// 1. Hello world Coroutine
fun coroutineHelloWord() {
    GlobalScope.launch {
        println("Hello World!")
        println()
    }
}
// 2. 3 types of Scope - runBlocking, GlobalScope, coroutineScope
suspend fun coroutineScope() {
    runBlocking {
        launch {
            delay(1000L)
            println("Run blocking scope")
        }

        kotlinx.coroutines.coroutineScope {
            launch {
                delay(500L)
                println("Run coroutineScope")
            }
        }
    }

    GlobalScope.launch {
        delay(1500L)
        println("Run global scope")
    }

    delay(3000L)
    println("Finish scope...")
    println()
}
// 3. Context
fun coroutineContext() {
    runBlocking(CoroutineName("test")) {
        launch {
            println("Coroutine key is ${coroutineContext.get(CoroutineName)}")
            delay(500L)
            println()
        }
    }
}
// 4. Suspending function with global var
var functionCount = 0
suspend fun functionCount() {
        funPrint1()
        funPrint2()
        delay(2000L)
        println("Function calls are: ${functionCount}")
        println()
}
suspend fun funPrint1() {
        println("Function 1 calculating....")
        delay(1000L)
        functionCount++
        println("Function 1 finished...")
}

suspend fun funPrint2() {
        println("Function 2 calculating....")
        delay(900L)
        functionCount++
        println("Function 2 finished...")
}

// 5. Jobs
fun jobs() {
    val job = GlobalScope.launch {
        println("Start job ...")
        delay(1000L)
        println("Job is finishing...")
    }

    job.invokeOnCompletion { println("Job finished.") }
    job.cancel()
    println()
}
// 6. Dispatcher
fun dispatcher() {
    // For Android / Gradle
//    runBlocking(Dispatchers.Main) {
//        launch {
//            println("Thread name is: ${Thread.currentThread().name}")
//        }
//    }

    runBlocking(Dispatchers.IO) {
        launch {
            println("Thread name is: ${Thread.currentThread().name}")
            delay(1000L)
            println("Thread name is: ${Thread.currentThread().name}")
        }
    }

    runBlocking(Dispatchers.Default) {
        launch {
            println("Thread name is: ${Thread.currentThread().name}")
        }
    }

    runBlocking(Dispatchers.Unconfined) {
        launch {
            println("Thread name is: ${Thread.currentThread().name}")
        }
    }
}
// 7. Async
fun asyncCoroutine() {
    runBlocking {
            val res1 = async {
                longComputation()
            }
            val res2 = async {
                longComputation()
            }
            val res3 = async {
                longComputation()
            }
            println("Result is:  ${res1.await() + res2.await() + res3.await()}")
            println()
    }
}

suspend fun longComputation(): Int {
    println("Long computation start...")
    delay(2000L)
    val res = Random.nextInt(1000)
    println("Result is: $res")
    return res
}
// 8. Error handling
suspend fun errorHandlingFunction() {
    val errorHandler = CoroutineExceptionHandler { _, exception ->
        println("Handle exception: ${exception.localizedMessage}")
    }
    val job = GlobalScope.launch(Dispatchers.IO + errorHandler) {
            throwErrorFun()
    }

    job.join()

    val res = GlobalScope.async {
            throwErrorFunArithmetic()
    }

    try {
      res.await()
    } catch (e: Exception) {
        println("Catch exception outside, exception is: ${e.localizedMessage}")
    }
}
suspend fun throwErrorFun() {
    println("Long computation start...")
    throw IndexOutOfBoundsException("index out of bound")
}

suspend fun throwErrorFunArithmetic(): Int {
    println("Long computation start...")
    throw ArithmeticException("arithmetic exception")
    return 0
}