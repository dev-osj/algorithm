package osj.beaver.baekjoon.bruteforce

import java.util.StringTokenizer

// 124ms 13172kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val numbers = mutableListOf<Int>()
    stringTokenizer = StringTokenizer(readln())
    repeat(n) {
        numbers.add(stringTokenizer.nextToken().toInt())
    }

    var max = 0
    for (i in 0 until numbers.size) {
        for (j in i+1 until numbers.size) {
            for (k in j+1 until numbers.size) {
                val sum = numbers[i] + numbers[j] + numbers[k]
                if (sum in (max + 1)..m) {
                    max = sum
                }
            }
        }
    }
    println(max)
}