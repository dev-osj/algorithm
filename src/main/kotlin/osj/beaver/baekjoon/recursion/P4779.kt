package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

// 196ms 26156kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()
    while(true) {
        val number = (reader.readLine() ?: break).toDouble()
        if (number == 0.0) {
            stringBuilder.appendLine("-")
        } else {
            val length = 3.0.pow(number).toInt()
            val array = CharArray(length) { '-' }
            cantorSet(array, 0, length)
            stringBuilder.appendLine(array)
        }
    }
    println(stringBuilder)
}

fun cantorSet(array: CharArray, front: Int, length: Int) {
    if (length < 3) {
        return
    }

    for (i in front + length / 3 until front + length / 3 * 2) {
        array[i] = ' '
    }

    cantorSet(array, front, length / 3)
    cantorSet(array, front + length / 3 * 2, length / 3)
}
