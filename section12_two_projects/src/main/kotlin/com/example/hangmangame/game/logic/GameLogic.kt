package com.example.hangmangame.game.logic

import com.example.hangmangame.game.visualisation.printCurrentState
import com.example.hangmangame.game.visualisation.printError

fun loopStep(guessesLeft: Int, gameWord: String, knownChar: List<Char>) {
    printCurrentState(guessesLeft, gameWord, knownChar)
    if (guessesLeft == 0) return
    if (isWinning(gameWord, knownChar)) return

    try {
        val nextChar = getUserChar()
        val res = calculateState(nextChar, guessesLeft, gameWord, knownChar)
        loopStep(res.first, gameWord, res.second)
    } catch (e: Exception) {
        printError("Your input is incorrect, pls try again. Input should be correct letter in English")
        loopStep(guessesLeft, gameWord, knownChar)
    }
}

fun validateInput(input: String): Char {
    if (input.isNotEmpty() && input.length == 1) {
        return input.toCharArray()[0]
    }
    throw Exception("User input is incorrect")
}
fun getUserChar(): Char {
    val userInput = readln()
    return validateInput(userInput)
}
fun isWinning(gameWord: String, knownChar: List<Char>): Boolean {
    return gameWord.all { knownChar.contains(it) }
}
fun calculateState(userChar: Char, guessesLeft: Int, word: String, knownChar: List<Char>): Pair<Int, List<Char>> {
    return if (word.contains(userChar)) {
        Pair(guessesLeft, knownChar + userChar)
    } else {
        Pair(guessesLeft - 1, knownChar + userChar)
    }
}
