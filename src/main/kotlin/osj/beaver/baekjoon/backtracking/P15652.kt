package osj.beaver.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


// 132ms 20568kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val stringBuilder = StringBuilder()
    p15652Dfs(IntArray(m), n, m, 0, 0, stringBuilder)
    println(stringBuilder)
}

fun p15652Dfs(array: IntArray, n: Int, m: Int, depth: Int, start: Int, stringBuilder: StringBuilder) {
    if (depth == m) {
        for (i in array.indices) {
            stringBuilder.append("${array[i]} ")
        }
        stringBuilder.appendLine()
        return
    }

    for (i in start until  n) {
        array[depth] = i + 1
        p15652Dfs(array, n, m, depth + 1, i, stringBuilder)
    }
}