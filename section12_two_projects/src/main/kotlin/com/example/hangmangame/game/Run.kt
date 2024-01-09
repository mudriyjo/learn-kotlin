package com.example.hangmangame.game

import com.example.hangmangame.game.logic.loopStep
import kotlin.random.Random


fun runGame(words: List<String>) {
    val guessesCnt = 6
    val gameWord = words[Random.nextInt(words.size)]

    loopStep(guessesCnt, gameWord, listOf())
}

