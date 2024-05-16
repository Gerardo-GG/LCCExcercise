package com.ibm.lcc_template.Exersices

fun main() {
    var listOfWords = listOf("apple", "plane", "sugar", "cherry", "car", "ball", "one")

    listOfWords = listOfWords.sortedBy {
        it.length
    }

    println(listOfWords)

    println("First: ${listOfWords.first()}, Last: ${listOfWords.last()}")
}

