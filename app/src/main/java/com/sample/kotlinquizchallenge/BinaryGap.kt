package com.sample.kotlinquizchallenge

/*
* Find the longest sequence of consecutive zeros in binary representation surrounded by ones.
*
* // Input
* findBinaryGap(9)   // Binary: 1001
* findBinaryGap(529) // Binary: 1000010001
* findBinaryGap(32)  // Binary: 100000
*
* // Expected Output
* 9 → 2
* 529 → 4
* 32 → 0 (no gap surrounded by ones)
* */

fun findBinaryGap(n: Int): Int {
    val binary = n.toString(2)
    var maxGap = 0
    var currentGap = 0
    var inGap = false
    
    for (char in binary) {
        when (char) {
            '1' -> {
                if (inGap) {
                    maxGap = maxOf(maxGap, currentGap)
                    currentGap = 0
                }
                inGap = true
            }
            '0' -> {
                if (inGap) {
                    currentGap++
                }
            }
        }
    }
    
    return maxGap
}

fun main() {
    println("Enter a positive integer: ")

    val inputStr = readLine()

    //empty input or whitespace
    if (inputStr.isNullOrBlank()) {
        println("Invalid input. That is not a valid number.")
        return
    }
    
    // try to convert string to integer
    val input = inputStr.toIntOrNull()
    if (input == null) {
        println("Invalid input. That is not a valid number.")
        return
    }

    // check for negative numbers or zero
    if (input <= 0) {
        println("Invalid input. Number must be greater than 0.")
        return
    }

    val gap = findBinaryGap(input)
    println("$input → $gap")
}
