package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.math.BigInteger
import java.util.StringTokenizer

// 96ms 12536kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toBigInteger()
    println(n * BigInteger.valueOf(4))
}
