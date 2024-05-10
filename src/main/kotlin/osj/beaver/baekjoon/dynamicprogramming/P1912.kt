package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 236ms 24028kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val stringTokenizer = StringTokenizer(reader.readLine())

    val array = IntArray(n)
    val dp = IntArray(n)
    repeat(n) {
        array[it] = stringTokenizer.nextToken().toInt()
    }

    dp[0] = array[0]
    var max = array[0]

    for (i in 1 until n) {
        dp[i] = (dp[i - 1] + array[i]).coerceAtLeast(array[i])
        max = max.coerceAtLeast(dp[i])
    }

    println(max)
}