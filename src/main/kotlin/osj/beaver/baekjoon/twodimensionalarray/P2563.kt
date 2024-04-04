package osj.beaver.baekjoon.twodimensionalarray

import java.util.StringTokenizer

// 128ms 18608kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()

    val array = Array(100) { IntArray(100) { 0 }}
    repeat(n) {
        stringTokenizer = StringTokenizer(readln())
        val x = stringTokenizer.nextToken().toInt()
        val y = stringTokenizer.nextToken().toInt()

        for (i in x until x + 10) {
            for (j in y until y + 10) {
                array[i][j] = 1
            }
        }
    }

    val result = array.sumOf { it.sum() }
    println(result)
}