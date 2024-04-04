package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

import java.util.StringTokenizer

// 112ms 13208mb
fun main() {
    val reader = System.`in`.bufferedReader()
    val t = reader.readLine().toInt()

    val stringBuilder = StringBuilder()
    repeat(t) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        val a = stringTokenizer.nextToken().toInt()
        val b = stringTokenizer.nextToken().toInt()
        var num1 = a
        var num2 = b
        var number: Int

        while (true) {
            number = num2 % num1
            if (number == 0) {
                break
            }
            num2 = num1
            num1 = number
        }
        stringBuilder.append("${b * a / num1}\n")
    }
    println(stringBuilder)
}