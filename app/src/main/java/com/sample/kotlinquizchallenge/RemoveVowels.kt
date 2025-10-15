package com.sample.kotlinquizchallenge

import java.util.Scanner

/*
* Write a function that removes all vowels from a string, case-insensitive.
*
* // Input
* removeVowels("Hello World")
* removeVowels("Kotlin Programming")
*
* // Expected Output
* "Hello World" → "Hll Wrld"
* "Kotlin Programming" → "Ktln Prgrmmng"
* */

fun removeVowels(input: String): String {
    return input.replace(Regex("[aeiouAEIOU]"), "")
}

fun main() {
    val scanner = Scanner(System.`in`)
    
    println("Enter a string to remove vowels:")
    val input = scanner.nextLine()
    
    // Input validation
    if (input.isBlank()) {
        println("Error: Input cannot be empty or blank")
        return
    }
    
    val output = removeVowels(input)
    
    // Output in the specified format
    println("\"$input\" → \"$output\"")
}
