package osj.beaver.baekjoon.sort

import java.util.StringTokenizer

// 460ms 54356kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    val array = Array(201) { mutableListOf<String>() }
    repeat(n) {
        stringTokenizer = StringTokenizer(readln())
        val age = stringTokenizer.nextToken().toInt()
        val name = stringTokenizer.nextToken()
        array[age].add(name)
    }


    val stringBuilder = StringBuilder()
    for (i in 1 .. 200) {
        array[i].forEach {
            stringBuilder.append("$i ${it}\n")
        }
    }
    println(stringBuilder)
}