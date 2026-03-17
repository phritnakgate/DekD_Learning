package com.example.dekd_learning.ui.unscramble_game.state

data class UnscrambleGameState (
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)