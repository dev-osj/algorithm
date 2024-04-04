package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 96ms, 12668kb
fun main() {
    val angleMap = hashMapOf<Int, Int>()
    repeat(3) {
        val stringTokenizer = StringTokenizer(readln())
        val angle = stringTokenizer.nextToken().toInt()
        angleMap[angle] = angleMap.getOrDefault(angle, 0) + 1
    }

    val sum = angleMap.entries.sumOf { it.key * it.value }
    if (sum != 180) {
        println("Error")
    } else {
        when(angleMap.keys.size) {
            1 -> println("Equilateral")
            2 -> println("Isosceles")
            3 -> println("Scalene")
        }
    }
}