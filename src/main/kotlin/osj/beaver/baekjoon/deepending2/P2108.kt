package osj.beaver.baekjoon.deepending2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.round

// 284ms 20848kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()

    val array = IntArray(8001) { 0 }
    var sum = 0
    var min = 4000
    var max = -4000
    repeat(n) {
        val number = reader.readLine().toInt()
        array[number + 4000] += 1
        sum += number

        if (min > number) {
            min = number
        }

        if (max < number) {
            max = number
        }
    }

    var count = 0
    var index = min + 4000
    var halfIndex = 0
    var countMax = 0
    var countIndex = 0
    var flag = false
    while (index <= max + 4000) {
        if (array[index] > 0) {
            if (count < (n + 1) / 2) {
                count += array[index]
                halfIndex = index
            }

            if (countMax < array[index]) {
                countMax = array[index]
                countIndex = index
                flag = true
            } else if (countMax == array[index] && flag) {
                countIndex = index
                flag = false
            }
        }

        index++
    }

    val stringBuilder = StringBuilder()
    stringBuilder.appendLine(round((sum.toDouble() / n)).toInt())
    stringBuilder.appendLine(halfIndex - 4000)
    stringBuilder.appendLine(countIndex - 4000)
    stringBuilder.appendLine(max - min)

    writer.write(stringBuilder.toString())
    writer.close()
}