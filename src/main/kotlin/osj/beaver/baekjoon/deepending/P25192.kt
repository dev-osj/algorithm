package osj.beaver.baekjoon.deepending

import java.io.BufferedReader
import java.io.InputStreamReader

// 248ms 28020kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    var set = hashSetOf<String>()
    var count = 0
    repeat(n) {
        val commend = reader.readLine()
        if (commend != "ENTER") {
            set.add(commend)
        } else {
            count += set.size
            set = hashSetOf()
        }
    }

    println(count + set.size)
}