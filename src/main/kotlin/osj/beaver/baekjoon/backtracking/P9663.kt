package osj.beaver.baekjoon.backtracking

import kotlin.math.abs

var count = 0

// 4880ms 13076kb
fun main() {
    val n = readln().toInt()
    p9663Dfs(n, 0, IntArray(n))
    println(count)
}

fun p9663Dfs(n: Int, depth: Int, array: IntArray) {
    if (depth == n) {
        count++
        return
    }

    for (y in 0 until n) {
        var result = true
        for (x in 0 until depth) {
            // 수직 || 대각선
            if (y == array[x] || abs(array[x] - y) == depth - x) {
                result = false
                break
            }
        }

        if (result) {
            array[depth] = y
            p9663Dfs(n, depth + 1, array)
        }
    }
}