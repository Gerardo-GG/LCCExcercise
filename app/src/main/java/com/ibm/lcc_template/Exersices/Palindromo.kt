package com.ibm.lcc_template.Exersices

import androidx.compose.ui.text.toLowerCase
import java.util.Locale


fun main() {
    var phrase = "Yo hago yoga hoy"
    phrase = phrase.replace(" ", "")
    phrase = phrase.lowercase(Locale.ROOT)

    println(validatePalindromo(phrase))
}

fun validatePalindromo(phrase: String): Boolean {
    val size = phrase.length - 1

    for (i in 0.. size) {
        if (phrase[i] != phrase[size - i]) {
            return false
        }
    }

    return true
}
