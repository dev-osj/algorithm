package osj.beaver.baekjoon.sort

import java.util.StringTokenizer

// 92ms 12360kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken()

    val intArray = IntArray(10)
    n.forEach {
        intArray[it.code - 48] += 1
    }

    val stringBuilder = StringBuilder()
    for(i in 9 downTo  0) {
        repeat(intArray[i]) {
            stringBuilder.append(i)
        }
    }
    println(stringBuilder)
}