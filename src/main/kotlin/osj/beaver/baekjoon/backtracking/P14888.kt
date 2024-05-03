package osj.beaver.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer



// 104ms 14620kb
fun main() {
    P14888().getResult()
}

class P14888 {
    private var max = Int.MIN_VALUE
    private var min = Int.MAX_VALUE

    fun getResult() {
        val reader = BufferedReader(InputStreamReader(System.`in`))
        val n = reader.readLine().toInt()
        var stringTokenizer = StringTokenizer(reader.readLine())
        val numbers = IntArray(n)
        repeat(n) {
            numbers[it] = stringTokenizer.nextToken().toInt()
        }

        val operator = IntArray(4)
        stringTokenizer = StringTokenizer(reader.readLine())
        repeat(4) {
            operator[it] = stringTokenizer.nextToken().toInt()
        }

        val stringBuilder = StringBuilder()
        backTracking(numbers, operator, n, numbers[0], 1)
        stringBuilder.appendLine(max)
        stringBuilder.appendLine(min)
        println(stringBuilder)
    }

    private fun backTracking(numbers: IntArray, operator: IntArray, n: Int, value: Int, depth: Int) {
        if (n == depth) {
            max = value.coerceAtLeast(max)
            min = value.coerceAtMost(min)
            return
        }

        for (i in 0 until 4) {
            if (operator[i] != 0) {
                operator[i] -= 1
                when (i) {
                    0 -> backTracking(numbers, operator, n, value + numbers[depth], depth + 1)
                    1 -> backTracking(numbers, operator, n, value - numbers[depth], depth + 1)
                    2 -> backTracking(numbers, operator, n, value * numbers[depth], depth + 1)
                    3 -> backTracking(numbers, operator, n, value / numbers[depth], depth + 1)
                }
                operator[i] += 1
            }
        }
    }
}