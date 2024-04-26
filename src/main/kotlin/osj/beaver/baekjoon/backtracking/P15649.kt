package osj.beaver.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 244ms 52740kb

val stringBuilder = StringBuilder()
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val visit = BooleanArray(n)
    val array = IntArray(m)
    p15649Dfs(0, visit, array, n, m)
    println(stringBuilder)
}

fun p15649Dfs(depth: Int, visit: BooleanArray, array: IntArray, n: Int, m: Int) {
    if (depth == m) {
        for (i in 0 until m) {
            stringBuilder.append("${array[i]} ")
        }
        stringBuilder.appendLine()
        return
    }

    for (i in 0 until n) {
        if (visit[i]) {
            continue
        }

        visit[i] = true
        array[depth] = i + 1
        p15649Dfs(depth + 1, visit, array, n, m)
        visit[i] = false

    }
    return
}
