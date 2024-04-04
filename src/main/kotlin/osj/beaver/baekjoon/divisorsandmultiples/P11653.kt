package osj.beaver.baekjoon.divisorsandmultiples

import java.util.StringTokenizer

// 92ms 12412kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    var n = stringTokenizer.nextToken().toInt()

    var divide = 2
    val sqrt = Math.sqrt(n.toDouble())

    while(divide <= sqrt) {
        if (n % divide == 0) {
            println(divide)
            n /= divide
        } else {
            divide += 1
        }
    }

    if (n > 1) {
        println(n)
    }
}