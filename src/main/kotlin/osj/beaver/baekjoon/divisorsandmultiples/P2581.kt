package osj.beaver.baekjoon.divisorsandmultiples

import java.util.StringTokenizer

// 100ms 12976kb
// 에라토스테네스의 체
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val m = stringTokenizer.nextToken().toInt()

    stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    val primes = BooleanArray(n+1) { true }
    primes[0] = false
    primes[1] = false

    var i = 2
    while(i*i <= n) {
        if (primes[i]) {
            for (j in i*i .. n step i) {
                primes[j] = false
            }
        }
        i++
    }

    var sum = 0
    var min = Int.MAX_VALUE
    for (j in m .. n) {
        if (primes[j]) {
            sum += j
            min = min.coerceAtMost(j)
        }
    }

    if (sum == 0) {
        println(-1)
    } else {
        println("$sum\n$min")
    }
}