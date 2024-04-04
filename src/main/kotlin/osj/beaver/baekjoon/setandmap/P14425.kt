package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer

// 352ms 39304kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val set = hashSetOf<String>()
    repeat(n) {
        set.add(reader.readLine())
    }

    var count = 0
    repeat(m) {
        val str = reader.readLine()
        if (set.contains(str)) {
            count += 1
        }
    }
    println(count)
}