package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

import java.io.BufferedReader
import java.io.InputStreamReader

// 204ms 14004kb
fun main() {
    val prime = BooleanArray(1000001) { true }
    prime[0] = false
    prime[1] = false

    var i = 2
    while (i * i < 1000000) {
        for (j in i * i..1000000 step i) {
            prime[j] = false
        }
        i++
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val t = reader.readLine().toInt()
    val stringBuilder = StringBuilder()
    repeat(t) {
        val number = reader.readLine().toInt()
        var count = 0
        for (j in 2 .. number/2) {
            if (prime[j] && prime[number - j]) {
                count++
            }
        }
        stringBuilder.appendLine(count)
    }

    println(stringBuilder)
}