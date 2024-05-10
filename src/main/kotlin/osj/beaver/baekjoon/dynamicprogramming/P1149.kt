package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 108ms 13368kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    var stringTokenizer: StringTokenizer

    val colors = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }

    repeat(n) {
        stringTokenizer = StringTokenizer(reader.readLine())
        colors[it][0] = stringTokenizer.nextToken().toInt()
        colors[it][1] = stringTokenizer.nextToken().toInt()
        colors[it][2] = stringTokenizer.nextToken().toInt()
    }

    for (i in 0 .. 2) {
        p1149(colors, dp, n, 0,i)
    }
    println(dp[0][0].coerceAtMost(dp[0][1]).coerceAtMost(dp[0][2]))
}

fun p1149(color: Array<IntArray>, dp:Array<IntArray>, n: Int, depth: Int, before: Int): Int {
    if (n == depth) {
        return 0
    }

    if (dp[depth][before] == 0) {
        val r = p1149(color, dp, n, depth + 1, 0)
        val g = p1149(color, dp, n, depth + 1, 1)
        val b = p1149(color, dp, n, depth + 1, 2)

        if (before == 0) {
            dp[depth][0] = g.coerceAtMost(b) + color[depth][0]
        } else if (before == 1) {
            dp[depth][1] = r.coerceAtMost(b) + color[depth][1]
        } else {
            dp[depth][2] = r.coerceAtMost(g) + color[depth][2]
        }
    }

    return dp[depth][before]
}