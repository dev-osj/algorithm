package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader

// 120ms 14324kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val array = IntArray(n + 1)
    repeat(n) {
        array[it + 1] = reader.readLine().toInt()
    }

    val dp = IntArray(n + 1)
    dp[1] = array[1]
    if (n >= 2) {
        dp[2] = array[1] + array[2]
    }

    for (i in 3 .. n) {
        val number = (dp[i-3] + array[i-1]).coerceAtLeast(dp[i-2]) + array[i]
        dp[i] = number.coerceAtLeast(dp[i-1])
    }

    println(dp[n])
}

/*
 i = 4

 1.
 0 0 x 0  dp[2] + array[4]

 2.
 0 x 0 0  dp[1] + array[3] + array[4]

 dp[i-2] | (dp[i-3] + array[i-1])
 */