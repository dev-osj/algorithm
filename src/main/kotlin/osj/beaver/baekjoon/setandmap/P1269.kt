package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer

// 744ms 85380kb
fun main() {
    val reader = System.`in`.bufferedReader()
    var stringTokenizer = StringTokenizer(reader.readLine())

    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val map = hashMapOf<String, Int>()

    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        val num = stringTokenizer.nextToken()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(m) {
        val num = stringTokenizer.nextToken()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    println(map.count { it.value == 1 })
}

// 시간초과
@Suppress("Unused")
fun p1269FirstTry() {
    val reader = System.`in`.bufferedReader()
    var stringTokenizer = StringTokenizer(reader.readLine())

    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    stringTokenizer = StringTokenizer(reader.readLine())
    val list1 = mutableListOf<String>()
    repeat(n) {
        val num = stringTokenizer.nextToken()
        list1.add(num)
    }

    stringTokenizer = StringTokenizer(reader.readLine())
    val list2 = mutableListOf<String>()
    repeat(m) {
        val num = stringTokenizer.nextToken()
        list2.add(num)
    }

    println((list1-list2).size + (list2-list1).size)
}