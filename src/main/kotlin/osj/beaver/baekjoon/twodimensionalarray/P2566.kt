package osj.beaver.baekjoon.twodimensionalarray

import java.util.StringTokenizer

// 132 ms 18648 KB
fun main() {
    var maxValue = -1
    var indices = IntArray(2)

    for(i in 0 until 9) {
        val stringTokenizer = StringTokenizer(readln())
        for (j in 0 until 9) {
            val value = stringTokenizer.nextToken().toInt()
            if (value > maxValue) {
                maxValue = value
                indices = intArrayOf(i + 1, j + 1)
            }
        }
    }

    val stringBuilder = StringBuilder()
    stringBuilder.append(maxValue)
    stringBuilder.append("\n")
    stringBuilder.append(indices.joinToString(" "))

    println(stringBuilder)
}