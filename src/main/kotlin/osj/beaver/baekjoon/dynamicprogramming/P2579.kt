package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader

// 96ms 12704kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val array = IntArray(n + 1)
    val dp = IntArray(n + 1)

    for (i in 1 .. n) {
        array[i] = reader.readLine().toInt()
    }

    dp[1] = array[1]

    if (n >= 2) {
        dp[2] = array[1] + array[2]
    }

    for (i in 3 .. n) {
        dp[i] = dp[i - 2].coerceAtLeast(dp[i - 3] + array[i - 1]) + array[i]
    }

    println(dp[n])
}
