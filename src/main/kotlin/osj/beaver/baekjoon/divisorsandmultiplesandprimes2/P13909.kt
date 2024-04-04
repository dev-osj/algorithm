package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

// 92ms 12208mb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toLong()

    var iter = 1L
    while (true) {
        if (iter * iter > n) {
            println(iter - 1)
            return
        } else if (iter * iter == n) {
            println(iter)
            return
        }
        iter++
    }
}