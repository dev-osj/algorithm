package osj.beaver.baekjoon.twodimensionalarray

// 248ms 25700kb
fun main() {
    var split = readln().split(" ")

    val (n, m)= split.map{ it.toInt() }
    val array = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        split = readln().split(" ")
        array[i] = split.map { it.toInt() }.toIntArray()
    }

    val stringBuilder = StringBuilder()
    for (i in 0 until n) {
        split = readln().split(" ")
        for (j in 0 until m) {
            array[i][j] += split[j].toInt()
            stringBuilder.append("${array[i][j]} ")
        }
        stringBuilder.append("\n")
    }

    println(stringBuilder)
}