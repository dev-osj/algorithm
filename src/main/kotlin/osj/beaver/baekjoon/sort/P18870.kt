package osj.beaver.baekjoon.sort

import java.util.StringTokenizer

// 2472ms 362072kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val list = mutableListOf<Int>()
    val set = sortedSetOf<Int>()
    val stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        val number = stringTokenizer.nextToken().toInt()
        list.add(number)
        set.add(number)
    }

    val map = hashMapOf<Int, Int>()
    var count = 0
    set.forEach {
        map[it] = count
        count++
    }

    val stringBuilder = StringBuilder()
    list.forEach {
        stringBuilder.append("${map[it]} ")
    }
    println(stringBuilder)
}