package osj.beaver.baekjoon.bruteforce

import java.util.StringTokenizer

// 92ms 12356kb

/*
n = k + k1 + k2...
1 <= k1 + k2 ... <= k length * 9
n - 1 >=  k  >= length * 9 - n
*/
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    for (k in n - 9 * n.toString().length until n) {
        val sum = k.toString().sumOf { it.code - 48 }
        if (k + sum == n) {
            println(k)
            return
        }
    }
    println(0)
}



// 312ms 68668kb
@Suppress("Unused")
fun p2231FirstTry() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    var iter = 0
    while(iter < n) {
        val iterSum = iter.toString().sumOf { it.digitToInt() }
        if (iter + iterSum == n) {
            println(iter)
            return
        }
        iter++
    }
    println(0)
}