package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 92ms 12668kb
fun main() {
    val xMap = hashMapOf<Int, Int>()
    val yMap = hashMapOf<Int, Int>()
    repeat(3) {
        val stringTokenizer = StringTokenizer(readln())
        val x = stringTokenizer.nextToken().toInt()
        val y = stringTokenizer.nextToken().toInt()

        xMap[x] = xMap.getOrDefault(x, 0) + 1
        yMap[y] = yMap.getOrDefault(y, 0) + 1
    }

    val x = xMap.keys.first { xMap.getOrDefault(it, 0) % 2 != 0 }
    val y = yMap.keys.first { yMap.getOrDefault(it, 0) % 2 != 0 }
    println("$x $y")
}