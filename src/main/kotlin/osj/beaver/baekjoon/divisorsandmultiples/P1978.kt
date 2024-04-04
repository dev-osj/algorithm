package osj.beaver.baekjoon.divisorsandmultiples

import java.util.StringTokenizer

// 96ms 12448kb
// 에라토스테네스의 체
fun main() {
    val primes = BooleanArray(1001) { true }
    primes[0] = false
    primes[1] = false

    var i = 2
    while(i*i <= 1000) {
        if (primes[i]) {
            for (j in i*i .. 1000 step i) {
                primes[j] = false
            }
        }
        i++
    }

    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    var answer = 0
    stringTokenizer = StringTokenizer(readln())
    for (i in 0 until n) {
        val number = stringTokenizer.nextToken().toInt()
        if (primes[number]) {
            answer++
        }
    }
    println(answer)
}