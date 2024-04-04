package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

import java.util.StringTokenizer

// 92ms 12248kb
fun main() {
    val reader = System.`in`.bufferedReader()

    var stringTokenizer = StringTokenizer(reader.readLine())
    val a = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()

    stringTokenizer = StringTokenizer(reader.readLine())
    val c = stringTokenizer.nextToken().toInt()
    val d = stringTokenizer.nextToken().toInt()

    var son = a * d + b * c
    var mom = b * d
    var gcd = 1

    var number: Int
    while(true) {
        number = mom % son
        if (number == 0) {
            gcd = son
            break
        }
        mom = son
        son = number
    }

    println("${(a * d + b * c) / gcd} ${b * d / gcd}")
}