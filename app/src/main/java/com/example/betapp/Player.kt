package com.example.betapp

data class Player(
    val rank: Int,
    val name: String,
    val points: Int,

    val flagUrl: String

    // Flaggen-Bilder lokal gespeichert: val flagDrawable: Int
)