package com.sample.kotlinquizchallenge

/*
*
* Write a function that takes the number of notifications a user has received and returns a summary string.
*
* Example
* -> 0 -> No Notifications
* -> 3-99 -> You have 3 Notifications
* -> 100+ -> You have Notifications 99+
* */

fun getNotificationSummary(count: Int): String {
    return when {
        count < 0 -> "Invalid Notification Count"
        count == 0 -> "No Notifications"
        count in 1..99 -> "You have ${count} Notifications"
        count >= 100 -> "You have Notifications 99+"
        else -> "Invalid Notification Count"
    }
}

fun main() {
    println("Enter the number of notifications:")
    val input = readLine()
    val count = try {
        input?.toInt()
    } catch (e: NumberFormatException) {
        null
    }
    if (count == null) {
        println("Invalid input! Please enter a valid integer.")
    } else {
        println(getNotificationSummary(count))
    }
}
