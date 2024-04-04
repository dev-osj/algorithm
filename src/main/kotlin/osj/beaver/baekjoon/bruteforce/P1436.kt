package osj.beaver.baekjoon.bruteforce

import java.util.StringTokenizer


// 140ms 12468kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    var n = stringTokenizer.nextToken().toInt()

    var iter = 665
    while(n != 0) {
        iter++
        var count = 0
        var temp = iter
        while(temp > 0) {
            if (temp % 10 == 6) {
                count++
            } else {
                count = 0
            }

            temp /= 10
            if (count == 3) {
                n--
            }
        }
    }
    println(iter)
}

// 메모리 초과
@Suppress("Unused")
fun p1436FirstTry() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    var iter = 665
    var count = 0
    while(count < n) {
        iter++
        val hasNumber = iter.toString().contains("6{3,}".toRegex())
        if (hasNumber) {
            count++
        }
    }
    println(iter)
}