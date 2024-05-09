package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader

// 88ms 12144kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val array = LongArray(101)
    array[1] = 1
    array[2] = 1
    array[3] = 1

    for (i in  4 .. 100) {
        array[i] = array[i-2] + array[i-3]
    }

    val stringBuilder = StringBuilder()
    val t = reader.readLine().toInt()
    repeat(t) {
        val index = reader.readLine().toInt()
        stringBuilder.appendLine(array[index])
    }

    println(stringBuilder)
}
