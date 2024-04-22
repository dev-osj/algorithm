package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.InputStreamReader

// 92ms 12176kb
fun main() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    println(p27433Factorial(n))
}

fun p27433Factorial(n: Int): Long {
    if (n < 1) return 1
    return n * p27433Factorial(n - 1)
}