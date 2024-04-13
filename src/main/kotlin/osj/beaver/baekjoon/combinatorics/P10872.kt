package osj.beaver.baekjoon.combinatorics

import java.io.BufferedReader
import java.io.InputStreamReader

// 88ms 12164kb
fun main() {
    var n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    var result = 1
    while(n != 0) {
        result *= n--
    }
    println(result)
}