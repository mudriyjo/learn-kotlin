package com.example.hangmangame.game.visualisation

import com.example.hangmangame.game.logic.isWinning

fun print0Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}

fun print1Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |           O")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}

fun print2Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |           O")
    println("   |           |")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}

fun print3Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |           O")
    println("   |          /|\\")
    println("   |            ")
    println("   |            ")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}

fun print4Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |           O")
    println("   |          /|\\")
    println("   |           |")
    println("   |            ")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}
fun print5Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |           O")
    println("   |          /|\\")
    println("   |           |")
    println("   |          / ")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}

fun print6Mistake() {
    println("   |-----------|")
    println("   |           |")
    println("   |           O")
    println("   |          /|\\")
    println("   |           |")
    println("   |          / \\")
    println("   |            ")
    println("  /|\\            ")
    println(" / | \\            ")
    println("/  |  \\            ")
}

fun printWord(word: String, knownChar: List<Char>) {
    val printWord = word.map { if (knownChar.contains(it)) it else "_" }
    println("Word: ${printWord.joinToString(separator = " ") }")
}

fun printGuesses(count: Int) {
    println("You have $count guess(es) left")
}

fun printAskLetter() {
    print("Please enter a letter: ")
}
fun printGameOver() {
    println("Game over!!!")
}

fun askBlock(guessesLeft: Int, word: String, knownChar: List<Char>) {
    printWord(word, knownChar)
    printGuesses(guessesLeft)
    printAskLetter()
}

fun printError(errorMessage: String) {
    println(errorMessage)
}
fun printCurrentState(guessesLeft: Int, word: String, knownChar: List<Char>) {
    if (isWinning(word, knownChar)) {
        println("You are Win !!!")
        println("Congratulation !!!")
    } else if (guessesLeft > 0) {
        when (guessesLeft) {
            6 -> print0Mistake()
            5 -> print1Mistake()
            4 -> print2Mistake()
            3 -> print3Mistake()
            2 -> print4Mistake()
            1 -> print5Mistake()
        }
        askBlock(guessesLeft, word, knownChar)
    } else {
        print6Mistake()
        printGameOver()
    }
}