package com.ibm.lcc_template.Exersices

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    val item = 11

    val indexOfItem = findIndexOfValue(list, item)
    println(indexOfItem)
}

fun findIndexOfValue(list: List<Int>, item: Int): Int {
    var start = 0
    var size = list.size

    while (start < size) {
        val middle = ( size + start ).ushr(1)
        val compare = item.compareTo(list[middle])


        when {
            compare < 0 -> size = middle
            compare > 0 -> start = middle + 1
            else -> return middle
        }
    }

    return -1
}
