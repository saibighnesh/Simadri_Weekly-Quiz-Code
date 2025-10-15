package com.sample.kotlinquizchallenge
/*
*
* Implement an auction bidding system where new bids must be higher than current bid.
*
* // Input
* placeBid(50)  // First bid
* placeBid(30)  // Too low
* placeBid(75)  // Valid higher bid
*
* // Expected Output
* 50 → 50 (accepted)
* 30 → null (rejected)
* 75 → 75 (accepted)
* */
var currentBid: Int? = null

fun placeBid(bid: Int): Int? {
    if (bid <= 0) {
        println("$bid → null (invalid)")
        return null
    }
    
    return if (currentBid == null || bid > currentBid!!) {
        currentBid = bid
        println("$bid → $bid (accepted)")
        bid
    } else {
        println("$bid → null (rejected)")
        null
    }
}

fun main() {
    println("Enter auction bids, separated by commas (e.g., 50,30,75):")
    val input = readLine()?.trim()
    
    if (input.isNullOrBlank()) {
        println("No bids entered.")
        return
    }
    
    val bids = input.split(",").map { it.trim() }.mapNotNull {
        val value = it.toIntOrNull()
        if (value == null || value <= 0) {
            println("$it → null (invalid)")
            null
        } else value
    }
    
    for (bid in bids) {
        placeBid(bid)
    }
}
