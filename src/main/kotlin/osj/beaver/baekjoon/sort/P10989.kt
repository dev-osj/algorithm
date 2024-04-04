package osj.beaver.baekjoon.sort

// 1656ms 481692kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val array = IntArray(10001) { 0 }
    repeat(n) {
        array[reader.readLine().toInt()] += 1
    }

    val stringBuilder = StringBuilder()
    for (i in 0 .. 10000) {
        repeat(array[i]) {
            stringBuilder.append(i)
            stringBuilder.appendLine()
        }
    }
    println(stringBuilder)
}