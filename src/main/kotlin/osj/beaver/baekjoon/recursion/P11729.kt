package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.InputStreamReader

// 388ms 84208kb
class P11729Hanoi {
    val stringBuilder = StringBuilder()
    var count: Int = 0

    fun hanoi(k: Int, from: Int, sub: Int, to: Int) {
        if (k == 0) return
        hanoi(k - 1, from, to, sub)
        stringBuilder.appendLine("$from $to")
        count++
        hanoi(k - 1, sub, from, to)
    }
}

fun main() {
    val k = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    val hanoi = P11729Hanoi()
    hanoi.hanoi(k, 1, 2, 3)
    hanoi.stringBuilder.insert(0, "${hanoi.count}\n")
    println(hanoi.stringBuilder)
}

