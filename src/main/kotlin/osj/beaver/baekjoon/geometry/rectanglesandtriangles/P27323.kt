package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 92ms 12292kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val a = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readln())
    val b = stringTokenizer.nextToken().toInt()

    println(a * b)
}