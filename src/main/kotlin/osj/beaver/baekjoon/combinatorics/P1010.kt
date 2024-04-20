package osj.beaver.baekjoon.combinatorics

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 96ms 12468kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val t = reader.readLine().toInt()
    var stringTokenizer: StringTokenizer
    val cache = Array(30) { IntArray(30) }
    val stringBuilder = StringBuilder()
    repeat(t) {
        stringTokenizer = StringTokenizer(reader.readLine())
        val n = stringTokenizer.nextToken().toInt()
        val m = stringTokenizer.nextToken().toInt()
        stringBuilder.appendLine(p1010Dp(cache, m,n))
    }
    println(stringBuilder)
}

fun p1010Dp(cache: Array<IntArray>, m: Int, n: Int): Int {
    if (m == n || n == 0) {
        return 1
    }

    if (cache[m][n] != 0) return cache[m][n]
    cache[m][n] = p1010Dp(cache, m - 1, n) + p1010Dp(cache, m - 1, n - 1)

    return cache[m][n]
}