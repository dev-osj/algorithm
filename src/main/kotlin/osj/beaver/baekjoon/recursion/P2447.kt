package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 284ms 69152kb
fun main() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val array = Array(n) { CharArray(n) { ' ' } }
    p2447PrintStar2(array, n, 0, 0)
    val stringBuilder = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            stringBuilder.append(array[i][j])
        }
        stringBuilder.appendLine()
    }
    writer.write(stringBuilder.toString())
    writer.close()
}

fun p2447PrintStar2(array: Array<CharArray>, length: Int, x: Int, y: Int) {
    if (length == 1) {
        array[x][y] = '*'
        return
    }

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i != 1 || j != 1) {
                p2447PrintStar2(array, length / 3, x + length / 3 * i, y + length / 3 * j)
            }
        }
    }
}

// 340ms 69320kb
@Suppress("Unused")
fun p2447FirstTry() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val array = Array(n) { CharArray(n) { '*' } }
    p2447PrintStar(array, n / 3, n / 3, n)
    val stringBuilder = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            stringBuilder.append(array[i][j])
        }
        stringBuilder.appendLine()
    }
    writer.write(stringBuilder.toString())
    writer.close()
}

fun p2447PrintStar(array: Array<CharArray>, row: Int, col: Int, length: Int) {
    if (length == 1) return

    val gap = length / 3
    for (i in row until  (row) + gap) {
        for (j in col until (col) + gap) {
            array[i][j] = ' '
        }
    }

    val first = (gap / 3) * 2
    val middle = gap / 3
    val rear = gap + gap / 3

    // lu
    p2447PrintStar(array, row - first, col - first, gap)
    // u
    p2447PrintStar(array, row - first, col + middle, gap)
    // ru
    p2447PrintStar(array, row - first , col + rear, gap)
    // l
    p2447PrintStar(array, row + middle , col - first, gap)
    // r
    p2447PrintStar(array, row + middle, col + rear, gap)
    // ld
    p2447PrintStar(array, row + rear, col - first, gap)
    // d
    p2447PrintStar(array, row + rear, col + middle, gap)
    // rd
    p2447PrintStar(array, row + rear, col + rear, gap)
}
