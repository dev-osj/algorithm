package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 120ms 13000kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val array = IntArray(n)
    val stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        array[it] = stringTokenizer.nextToken().toInt()
    }

    val dp = IntArray(n)
    dp[0] = 1

    var max = 1
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (array[j] < array[i]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                if (dp[i] > max) {
                    max = dp[i]
                }
            }

            if (dp[i] == 0) {
                dp[i] = 1
            }
        }
    }
    println(max)
}