package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer

// 556ms 60968kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val set = sortedSetOf<String>(Comparator.reverseOrder())
    repeat(n) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        val name = stringTokenizer.nextToken()
        val inOut = stringTokenizer.nextToken() == "enter"

        if (inOut) {
            set.add(name)
        } else {
            set.remove(name)
        }
    }

    val stringBuilder = StringBuilder()
    for (name in set) {
        stringBuilder.append("$name\n")
    }

    println(stringBuilder)
}