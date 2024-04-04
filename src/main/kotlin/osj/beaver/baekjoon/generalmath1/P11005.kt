package osj.beaver.baekjoon.generalmath1

import java.util.StringTokenizer

// 88ms 12368kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    var number = stringTokenizer.nextToken().toInt()
    val formation = stringTokenizer.nextToken().toInt()

    if (number == 0) {
        println(0)
        return
    }

    val stringBuilder = StringBuilder()
    while(number > 0) {
        val num = number % formation
        if (num in 10 .. 35) {
            stringBuilder.append((num + 55).toChar())
        } else {
            stringBuilder.append(num)
        }
        number /= formation
    }
    println(stringBuilder.reverse())
}