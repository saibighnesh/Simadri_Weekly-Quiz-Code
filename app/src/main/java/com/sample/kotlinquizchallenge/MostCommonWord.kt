package com.sample.kotlinquizchallenge

/*
* Find the most frequently occurring word, ignoring common stop words.
*
* // Input
* findMostCommonWord("The sun shines and the sky is blue and clear")
*
* // Expected Output
* "The sun shines and the sky is blue and clear" → "and"
*
* */

// Set of common stop words to ignore
val stopWords = setOf(
    "the", "a", "an", "is", "it", "to", "of", "in", "on", "at", "for", "with", "as"
)

fun findMostCommonWord(text: String): String? {
    // Convert text to lowercase and extract words
    val words = text.lowercase()
        .split("\\s+".toRegex())
        .map { it.replace("[^a-z]".toRegex(), "") }
        .filter { it.isNotEmpty() && !stopWords.contains(it) }
    
    // Count word frequencies
    val wordCount = words.groupingBy { it }.eachCount()
    
    // Find the most common word
    return wordCount.maxByOrNull { it.value }?.key
}

fun main() {
    println("Enter a sentence to find the most common word:")
    val input = readLine() ?: ""
    
    if (input.isEmpty()) {
        println("No input provided.")
        return
    }
    
    val result = findMostCommonWord(input)
    
    if (result != null) {
        println("\"$input\" → \"$result\"")
    } else {
        println("No common words found.")
    }
}
