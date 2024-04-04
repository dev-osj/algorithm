package osj.beaver.baekjoon.sort


// 812ms 108884kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val array = Array(200001) { mutableListOf<Int>() }

    repeat(n) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        array[y + 100000].add(x)
    }

    val stringBuilder = StringBuilder()
    for (i in 0 .. 200000) {
        array[i].sort()
        array[i].forEach{
            stringBuilder.append("$it ${i-100000}")
            stringBuilder.appendLine()
        }
    }
    println(stringBuilder)
}