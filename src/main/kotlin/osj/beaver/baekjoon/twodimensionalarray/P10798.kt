package osj.beaver.baekjoon.twodimensionalarray

import java.util.StringTokenizer

// 128ms 18804kb
fun main() {
    val arrays = Array(5) { CharArray(15) }
    var maxLength = 0
    for(i in 0 until 5) {
        val stringTokenizer = StringTokenizer(readlnOrNull())
        val row = stringTokenizer.nextToken().toCharArray()
        maxLength = maxLength.coerceAtLeast(row.size)
        arrays[i] = row
    }

    val stringBuilder = StringBuilder()
    for(i in 0 until maxLength) {
        for (j in 0 until 5) {
            val char = arrays[j].getOrNull(i) ?: ""
            stringBuilder.append(char)
        }
    }

    println(stringBuilder)
}