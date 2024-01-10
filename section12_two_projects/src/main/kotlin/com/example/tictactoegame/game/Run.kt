package com.example.tictactoegame.game

import com.example.tictactoegame.game.logic.loopStep

fun runGame() {
    val board = Array(3){ Array(3) {0} }
    loopStep(board, false, false)
}

