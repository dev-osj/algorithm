package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 320ms 26612kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    if (n == 1) {
        println(0)
        return
    }

    var maxX = -10001
    var maxY = -10001
    var minX = 10001
    var minY = 10001

    repeat(n) {
        stringTokenizer = StringTokenizer(readln())
        val x = stringTokenizer.nextToken().toInt()
        val y = stringTokenizer.nextToken().toInt()

        maxX = maxX.coerceAtLeast(x)
        maxY = maxY.coerceAtLeast(y)
        minX = minX.coerceAtMost(x)
        minY = minY.coerceAtMost(y)
    }

    println((maxX - minX) * (maxY - minY))
}