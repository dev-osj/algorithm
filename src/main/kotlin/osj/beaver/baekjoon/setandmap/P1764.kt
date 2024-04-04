package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer


// 336ms 34164kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val map = hashMapOf<String, Boolean>()
    val list = mutableListOf<String>()
    repeat(n) {
        val name = reader.readLine()
        map[name] = true
    }

    repeat(m) {
        val name = reader.readLine()
        if(map.getOrDefault(name, false)) {
            list.add(name)
        }
    }
    list.sort()

    println("${list.size}\n${list.joinToString("\n")}")
}