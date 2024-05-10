package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 240ms 25108kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    var stringTokenizer: StringTokenizer
    val array = Array(n) { IntArray(n) }
    val dp = Array(n) { IntArray(n) }

    repeat(n) {
        stringTokenizer = StringTokenizer(reader.readLine())
        for (i in 0..it) {
            array[it][i] = stringTokenizer.nextToken().toInt()
        }
    }

    dp[0][0] = array[0][0]
    repeat(n - 1) {
        for (i in 0 .. it+1) {
            if (i == 0) {
                dp[it + 1][i] = dp[it][i] + array[it + 1][i]
            } else if (i == it+1) {
                dp[it + 1][i] = dp[it][i-1]  + array[it + 1][i]
            } else {
                dp[it + 1][i] = dp[it][i].coerceAtLeast(dp[it][i-1])  + array[it + 1][i]
            }
        }
    }

    var max = 0
    dp[n-1].forEach {
        if (max < it) {
            max = it
        }
    }
    println(max)
}