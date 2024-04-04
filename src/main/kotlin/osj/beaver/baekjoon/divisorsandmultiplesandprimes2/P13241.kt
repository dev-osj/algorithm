package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

import java.util.StringTokenizer

// 92ms 12280kb
fun main() {
    val reader = System.`in`.bufferedReader()

    val stringTokenizer = StringTokenizer(reader.readLine())
    val a = stringTokenizer.nextToken().toLong()
    val b = stringTokenizer.nextToken().toLong()
    var num1 = a
    var num2 = b
    var number: Long

    while (true) {
        number = num2 % num1
        if (number == 0L) {
            break
        }
        num2 = num1
        num1 = number
    }

    println("${b * a / num1}")
}