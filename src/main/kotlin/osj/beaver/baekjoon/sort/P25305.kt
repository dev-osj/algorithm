package osj.beaver.baekjoon.sort

import java.util.StringTokenizer

// 100ms 14192kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()
    var k = stringTokenizer.nextToken().toInt()

    val array = IntArray(10001) { 0 }
    stringTokenizer = StringTokenizer(readln())
    repeat(n) {
        val number = stringTokenizer.nextToken().toInt()
        array[number] += 1
    }

    for (i in 10000 downTo 0) {
        k -= array[i]
        if (k <= 0) {
            println(i)
            return
        }
    }
}