package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer

// 1068ms 238276kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val map = hashMapOf<String, Int>()
    var stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        val num = stringTokenizer.nextToken()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val stringBuilder = StringBuilder()
    val m = reader.readLine().toInt()
    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(m) {
        val num = stringTokenizer.nextToken()
        stringBuilder.append("${map.getOrDefault(num, 0)} ")
    }
    println(stringBuilder)
}