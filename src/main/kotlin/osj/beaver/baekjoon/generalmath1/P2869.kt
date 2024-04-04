package osj.beaver.baekjoon.generalmath1

import java.util.StringTokenizer

// 92ms 12312kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val up = stringTokenizer.nextToken().toInt()
    val down = stringTokenizer.nextToken().toInt()
    val high = stringTokenizer.nextToken().toInt()

    var day = (high - down) / (up - down)
    if ((high - down) % (up - down) != 0) {
        day += 1
    }
    println(day)
}