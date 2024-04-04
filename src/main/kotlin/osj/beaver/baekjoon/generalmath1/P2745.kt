package osj.beaver.baekjoon.generalmath1

import java.util.StringTokenizer

// 92ms 12368kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val number = stringTokenizer.nextToken()
    val formation = stringTokenizer.nextToken().toInt()

    var digit = 1
    var result = 0
    for(i in number.length - 1 downTo 0) {
        val num = if(number[i] in 'A' .. 'Z') {
            number[i].code - 55
        } else {
            number[i].code - 48
        }

        result += num * digit
        digit *= formation
    }

    println(result)
}