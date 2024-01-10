package com.example.tictactoegame.game.visualisation

fun getSign(num: Int): String {
    return when (num) {
        1 -> "X"
        2 -> "O"
        else -> " "
    }
}
fun printBoard(board: Array<Array<Int>>) {
    val columnLength = board.size
    val rowLength = board[0].size
    for (x in 0 until rowLength) {
            println("---|---|---|---|")
        for (y in 0 until columnLength) {
            if (y == 0) {
                print(" $x | ${getSign(board[x][y])} ")
            } else {
                print("| ${getSign(board[x][y])} ")
            }
        }
        println("|")
    }
    println("---|---|---|---|")
    println("x\\y| 0 | 1 | 2 |")
}

fun printAskMove() {
    print("Please choose your turn, example of input: 1, 2 : ")
}
fun printFinish(isPlayerWin: Boolean) {
    if (isPlayerWin) {
        println("Congratulations you are win!!!")
    } else {
        println("Game over, computer is win!!!")
    }
}

fun printError(errorMessage: String) {
    println(errorMessage)
}
fun printCurrentState(board: Array<Array<Int>>, isGameFinish: Boolean, isPlayerWin: Boolean) {
    if (isGameFinish) {
        printFinish(isPlayerWin)
    } else {
        printBoard(board)
        printAskMove()
    }
}