package osj.beaver.baekjoon.combinatorics

import java.io.BufferedReader
import java.io.InputStreamReader

// 88ms 12136kb
fun main() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    println(1 shl n)
}