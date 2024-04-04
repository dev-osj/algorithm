package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

import kotlin.math.sqrt

// 368ms 12712kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val iter = reader.readLine().toInt()
    val stringBuilder = StringBuilder()
    repeat(iter) {
        var n = reader.readLine().toLong()
        while(!isPrime(n)) {
            n++
        }
        stringBuilder.appendLine(n)
    }

    println(stringBuilder)
}

fun isPrime(number: Long): Boolean {
    if (number < 2L) {
        return false
    }

    var iter = 2L
    while(iter <= sqrt(number.toDouble())) {
        if (number % iter == 0L) {
            return false
        }
        iter++
    }
    return true
}