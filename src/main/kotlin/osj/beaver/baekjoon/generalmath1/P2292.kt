package osj.beaver.baekjoon.generalmath1

import java.util.StringTokenizer

// 96ms 12400kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val num = stringTokenizer.nextToken().toInt()

    var i = 1
    var maxValue = 1
    while (true) {
        maxValue += (6 * (i - 1))
        if (num <= maxValue) {
            println(i)
            return
        }
        i += 1
    }
}