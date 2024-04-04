package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 100ms 12880kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val x = stringTokenizer.nextToken().toInt()
    val y = stringTokenizer.nextToken().toInt()
    val w = stringTokenizer.nextToken().toInt()
    val h = stringTokenizer.nextToken().toInt()

    val up = (w - x).coerceAtMost(h - y)
    val down = (x-0).coerceAtMost(y-0)
    println(up.coerceAtMost(down))
}