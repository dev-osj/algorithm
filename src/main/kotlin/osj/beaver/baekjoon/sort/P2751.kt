package osj.beaver.baekjoon.sort

// 708ms 172316kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val array = BooleanArray(2000001) { false }
    repeat(n) {
        array[reader.readLine().toInt() + 1000000] = true
    }

    val stringBuilder = StringBuilder()
    for(i in 0 .. 2000000) {
        if (array[i]) {
            stringBuilder.append("${i - 1000000}\n")
        }
    }
    println(stringBuilder)
}