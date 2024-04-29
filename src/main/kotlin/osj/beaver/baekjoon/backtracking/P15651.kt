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
    p15651Dfs(IntArray(m), n, m, 0, stringBuilder)
    println(stringBuilder )
}

fun p15651Dfs(array: IntArray, n: Int, m: Int, depth: Int, stringBuilder: StringBuilder) {
    if (depth == m) {
        for (i in array.indices) {
            stringBuilder.append("${array[i]} ")
        }
        stringBuilder.appendLine()
        return
    }

    for (i in 0 until n) {
        array[depth] = i + 1
        p15651Dfs(array, n, m, depth + 1, stringBuilder)
    }
}