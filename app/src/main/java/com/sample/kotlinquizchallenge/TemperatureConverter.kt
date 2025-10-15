package com.sample.kotlinquizchallenge

/*
* Write a higher-order function that can convert between Celsius and Fahrenheit.
*
* convertTemperature(25.0, celsiusToFahrenheit) //needs to be a higher order function
* convertTemperature(98.6, fahrenheitToCelsius)
*
* // Expected Output
* 25.0 → 77.0
* 98.6 → 37.0
* */

// Higher-order function that takes a temperature value and a conversion function
fun convertTemperature(temperature: Double, conversionFunction: (Double) -> Double): Double {
    return conversionFunction(temperature)
}

// Conversion function: Celsius to Fahrenheit
val celsiusToFahrenheit: (Double) -> Double = { celsius ->
    celsius * 9 / 5 + 32
}

// Conversion function: Fahrenheit to Celsius
val fahrenheitToCelsius: (Double) -> Double = { fahrenheit ->
    (fahrenheit - 32) * 5 / 9
}

// Input validation function
fun isValidTemperature(temp: Double, isCelsius: Boolean): Boolean {
    return if (isCelsius) {
        temp >= -273.15 // Absolute zero in Celsius
    } else {
        temp >= -459.67 // Absolute zero in Fahrenheit
    }
}

// Format output function
fun formatOutput(input: Double, output: Double): String {
    return "$input → $output"
}

fun main() {
    // Test cases with input validation
    val testCases = listOf(
        Triple(25.0, celsiusToFahrenheit, true),
        Triple(98.6, fahrenheitToCelsius, false)
    )
    
    println("Temperature Conversion Results:")
    println("================================")
    
    for ((temp, conversionFunc, isCelsius) in testCases) {
        if (isValidTemperature(temp, isCelsius)) {
            val result = convertTemperature(temp, conversionFunc)
            val roundedResult = Math.round(result * 10.0) / 10.0
            println(formatOutput(temp, roundedResult))
        } else {
            println("Invalid temperature: $temp (below absolute zero)")
        }
    }
}
