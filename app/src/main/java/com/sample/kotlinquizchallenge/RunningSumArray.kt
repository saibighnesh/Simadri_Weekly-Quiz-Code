package com.sample.kotlinquizchallenge

/*
* Return a new array where each element is the sum of all previous elements.
*
* // Input
* runningSum(intArrayOf(1, 2, 3, 4))
* runningSum(intArrayOf(3, 1, 2, 10, 1))
*
* // Expected Output
* [1, 2, 3, 4] → [1, 3, 6, 10]
* [3, 1, 2, 10, 1] → [3, 4, 6, 16, 17]
* */

fun runningSum(arr: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var sum = 0
    for (num in arr) {
        sum += num
        result.add(sum)
    }
    return result
}

fun main() {
    print("Enter numbers separated by commas: ")
    val input = readLine()?.trim()
    if (input.isNullOrBlank()) {
        println("Invalid input! Please enter a list of numbers.")
        return
    }

    val arr = input.split(",")
        .map { it.trim() }
        .mapNotNull {
            val num = it.toIntOrNull()
            if (num == null) {
                println("Error: '$it' is not a valid integer.")
            }
            num
        }

    if (arr.isEmpty()) {
        println("No valid numbers entered.")
        return
    }

    val result = runningSum(arr)
    println("${arr} → ${result}")
}
