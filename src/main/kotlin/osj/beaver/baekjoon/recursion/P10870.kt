package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.InputStreamReader

// 88ms 12164kb
fun main() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    println(p10870Fibonacci(n))
}

fun p10870Fibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1

    return p10870Fibonacci(n - 1) + p10870Fibonacci(n - 2)
}