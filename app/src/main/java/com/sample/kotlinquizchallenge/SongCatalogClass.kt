package com.sample.kotlinquizchallenge

/*
*
* Create a Song class with properties and computed properties.
*
* // Input
* val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)
*
* // Expected Output
* song.formattedDuration → "05:54"
* song.isPopular() → true
*
* */

data class Song(
    val title: String,
    val artist: String,
    val playCount: Int,
    val durationSeconds: Int
) {
    val formattedDuration: String
        get() {
            val minutes = durationSeconds / 60
            val seconds = durationSeconds % 60
            return "%02d:%02d".format(minutes, seconds)
        }

    fun isPopular(): Boolean = playCount >= 1_000_000
}

fun main() {
    print("Enter song title: ")
    val title = readLine()?.trim().orEmpty()
    print("Enter song artist: ")
    val artist = readLine()?.trim().orEmpty()
    print("Enter song play count: ")
    val playCountStr = readLine()?.trim()
    print("Enter song duration in seconds: ")
    val durationStr = readLine()?.trim()

    val playCount = playCountStr?.toIntOrNull()
    val durationSeconds = durationStr?.toIntOrNull()

    if (title.isBlank() || artist.isBlank() || playCount == null || durationSeconds == null || playCount < 0 || durationSeconds < 0) {
        println("Invalid input! Make sure all fields are provided and valid (numbers must be positive).")
        return
    }

    val song = Song(title, artist, playCount, durationSeconds)
    println("song.formattedDuration → \"${song.formattedDuration}\"")
    println("song.isPopular() → ${song.isPopular()}")
}
