package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

import java.util.StringTokenizer

// 232ms 26720kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val stringTokenizer = StringTokenizer(reader.readLine())
    val m = stringTokenizer.nextToken().toInt()
    val n = stringTokenizer.nextToken().toInt()

    val array = BooleanArray(n + 1) { true }
    array[0] = false
    array[1] = false

    var i = 2
    while(i*i <= n) {
        if (array[i]) {
            for (j in i*i .. n step i) {
                array[j] = false
            }
        }
        i++
    }

    val stringBuilder = StringBuilder()
    for(k in m .. n) {
        if (array[k]) {
            stringBuilder.append("$k\n")
        }
    }
    println(stringBuilder)
}