package osj.beaver.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    val stringBuilder = StringBuilder()
    p15650Dfs(IntArray(m), BooleanArray(n), n, m, 1, 0, stringBuilder)
    println(stringBuilder)
}

fun p15650Dfs(array: IntArray, visit: BooleanArray, n: Int, m: Int, start: Int, depth: Int, stringBuilder: StringBuilder) {
    if (depth == m) {
        for (i in 0 until m) {
            stringBuilder.append("${array[i]} ")
        }
        stringBuilder.appendLine()
        return
    }

    for (i in start .. n) {
        if (visit[i - 1]) {
            continue
        }

        visit[i - 1] = true
        array[depth] = i
        p15650Dfs(array, visit , n, m, i + 1, depth + 1, stringBuilder)
        visit[i - 1] = false
    }
}