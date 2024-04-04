package osj.beaver.baekjoon.generalmath1

import java.util.StringTokenizer
import kotlin.math.pow

// 88ms 12340kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val num = stringTokenizer.nextToken().toInt()

    var result = 2.0
    for (i in 1 .. num) {
        result += 2.0.pow(i-1).toInt()
    }
    println(result.pow(2).toInt())
}