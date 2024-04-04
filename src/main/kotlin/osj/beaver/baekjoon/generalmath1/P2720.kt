package osj.beaver.baekjoon.generalmath1

import java.util.StringTokenizer

// 104ms 13104kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()
    val tokens = arrayOf(25, 10, 5, 1)

    val stringBuilder = StringBuilder()
    for (i in 0 until n) {
        stringTokenizer = StringTokenizer(readln())
        var change = stringTokenizer.nextToken().toInt()
        tokens.forEach {
            val count = change / it
            stringBuilder.append("$count ")
            change %= it
        }
        stringBuilder.append("\n")
    }
    println(stringBuilder)
}