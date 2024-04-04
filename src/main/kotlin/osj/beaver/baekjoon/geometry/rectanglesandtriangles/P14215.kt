package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 120ms 14420kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val a = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()
    val c = stringTokenizer.nextToken().toInt()
    val sides = mutableListOf(a, b, c)
    sides.sort()

    if (sides[0] + sides[1] > sides[2]) {
        println(sides.sum())
    } else {
        println((sides[0] + sides[1]) * 2 - 1)
    }
}