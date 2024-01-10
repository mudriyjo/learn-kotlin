package com.example.tictactoegame.game.logic

import com.example.tictactoegame.game.visualisation.printCurrentState
import com.example.tictactoegame.game.visualisation.printError

fun loopStep(board: Array<Array<Int>>, isGameFinish: Boolean, isPlayerWin: Boolean) {
    printCurrentState(board, isGameFinish, isPlayerWin)
    if (isGameFinish) return

    try {
        val nextPlayerMove = getNextMove(board.lastIndex, board[0].lastIndex)
        val boardWithPlayerMove = playerMakeMove(board, nextPlayerMove)
        if (isWin(board)) {
            return loopStep(boardWithPlayerMove, true, true)
        }
        val boardWithPlayerAndPc = pcMakeMove(boardWithPlayerMove)
        if (isWin(board)) {
            return loopStep(boardWithPlayerAndPc, true, false)
        }
        return loopStep(boardWithPlayerAndPc, isGameFinish, isPlayerWin)
    } catch (e: Exception) {
        printError("Your input is incorrect, pls try again. ${e.localizedMessage}")
        return loopStep(board, isGameFinish, isPlayerWin)
    }
}

// Check condition whole line should be filled
fun isWin(board: Array<Array<Int>>): Boolean {
    // Check vertical
    for (i in 0..board.lastIndex) {
        val line = board.map { it[i] }
        val isWin = line.all { it == 1 } || line.all { it == 2 }
        if(isWin) return isWin
    }
    // Check Horizontal
    val res = board.map{yArr -> yArr.all {it == 1 } || yArr.all {it == 2 }}
    if (res.contains(true)) return true
    // Check diagonal
    return board[0][0] == board[1][1] && board[1][1] == board[2][2]
}

private fun pcMakeMove(board: Array<Array<Int>>): Array<Array<Int>> {
    val possibleMove = board.flatMapIndexed{xI, yArray ->
        yArray.mapIndexed{yI, el -> Triple(el, xI,yI)}.filter{ it.first == 0 }.map{Pair(it.second, it.third)}}
    val randomMove = possibleMove.random()
    board[randomMove.first][randomMove.second] = 2
    return board
}

private fun playerMakeMove(board: Array<Array<Int>>, nextPlayerMove: Pair<Int, Int>): Array<Array<Int>> {
    if (!canMakeMove(board, nextPlayerMove)) {
        throw MoveExistException("Can't make a move position already occupied")
    }
    board[nextPlayerMove.first][nextPlayerMove.second] = 1
    return board
}

fun validateInput(input: String, xLimit: Int, yLimit: Int): Pair<Int, Int> {
    val res = input.trim(' ').split(",")
    if (res.size == 2) {
        val x = res[0].toInt()
        val y = res[1].toInt()
        if (x < 0 || x > xLimit || y < 0 || y > yLimit) {
            throw Exception("User input is incorrect," +
                    " input interval for " +
                    "x should be between 0 and $xLimit, for y should be between 0 and $yLimit")
        }
        return Pair(x,y)
    }
    throw Exception("User input is incorrect, use next template for input: 1, 1")
}
fun getNextMove(xLimit: Int, yLimit: Int): Pair<Int,Int> {
    val userInput = readln()
    return validateInput(userInput, xLimit, yLimit)
}
fun canMakeMove(board: Array<Array<Int>>, move: Pair<Int, Int>): Boolean {
    return board[move.first][move.second] == 0
}

class MoveExistException(message: String?) : Exception(message)