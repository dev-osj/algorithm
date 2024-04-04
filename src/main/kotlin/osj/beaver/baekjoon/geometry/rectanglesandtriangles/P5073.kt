package osj.beaver.baekjoon.geometry.rectanglesandtriangles

import java.util.StringTokenizer

// 96ms 13364kb
fun main() {
    while(true) {
        val stringTokenizer = StringTokenizer(readln())
        val a = stringTokenizer.nextToken().toInt()
        val b = stringTokenizer.nextToken().toInt()
        val c = stringTokenizer.nextToken().toInt()

        val maxSide = a.coerceAtLeast(b).coerceAtLeast(c)
        val sum = a + b + c
        if (sum == 0) {
            return
        } else if ((sum - maxSide) <= maxSide) {
            println("Invalid")
            continue
        }

        val sideMap = hashMapOf<Int, Int>()
        sideMap[a] = sideMap.getOrDefault(a, 0) + 1
        sideMap[b] = sideMap.getOrDefault(b, 0) + 1
        sideMap[c] = sideMap.getOrDefault(c, 0) + 1

        when(sideMap.size) {
            1 -> println("Equilateral")
            2 -> println("Isosceles")
            3 -> println("Scalene")
        }
    }
}