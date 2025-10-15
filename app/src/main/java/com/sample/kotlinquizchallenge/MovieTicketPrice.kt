package com.sample.kotlinquizchallenge
/*
*
* Create a function that calculates movie ticket price based on age and showtime.
*
* // Input
* calculateTicketPrice(age = 25, isMatinee = false) // Adult, evening
* calculateTicketPrice(age = 70, isMatinee = true)  // Senior, matinee
* calculateTicketPrice(age = 8, isMatinee = false)  // Child, evening
*
* // Expected Output
* 25, false → 15
* 70, true → 8
* 8, false → 8
*
* */
fun calculateTicketPrice(age: Int, isMatinee: Boolean): Int? {
    if (age !in 0..120) {
        println("Error: Age must be between 0 and 120.")
        return null
    }
    return when {
        age < 13 -> 8
        age >= 65 && isMatinee -> 8
        age >= 65 -> 10
        isMatinee -> 10
        else -> 15
    }
}

fun main() {
    print("Enter age: ")
    val ageInput = readLine()
    val age = ageInput?.toIntOrNull()
    
    if (age == null || age !in 0..120) {
        println("Invalid age! Please enter a number between 0 and 120.")
        return
    }
    
    print("Is it a matinee show? (yes/no): ")
    val showInput = readLine()?.trim()?.lowercase()
    val isMatinee = when (showInput) {
        "yes", "y", "true" -> true
        "no", "n", "false" -> false
        else -> {
            println("Invalid input for showtime! Enter yes or no.")
            return
        }
    }
    
    val price = calculateTicketPrice(age, isMatinee)
    if (price != null) {
        println("$age, $isMatinee → $price")
    }
}
