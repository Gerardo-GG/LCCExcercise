package com.ibm.lcc_template.Exersices

fun main() {
    println(matchingStrings(arrayOf("asd", "asd", "qweqwe", "q"), arrayOf("asd", "q", "nada", "algo")).joinToString(","))
}

fun matchingStrings(stringList: Array<String>, queries: Array<String>): Array<Int> {
    // Write your code here
    val result = mutableListOf<Int>()
    val inputMap = stringList.groupBy { it }

    queries.forEach {
        result.add(
            inputMap.get(it)?.size ?: 0
        )
    }

    return result.toTypedArray()
}