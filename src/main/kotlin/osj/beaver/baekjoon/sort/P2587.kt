package osj.beaver.baekjoon.sort

import java.util.StringTokenizer

// 92ms 12356kb
fun main() {
    var sum = 0
    val list = IntArray(11) { 0 }
    repeat(5) {
        val stringTokenizer = StringTokenizer(readln())
        val input = stringTokenizer.nextToken().toInt()
        sum += input
        list[input/10] += 1
    }

    var count = 0
    list.forEachIndexed { index, i ->
        count += i
        if (count > 2) {
            println("${sum/5}\n${index*10}")
            return
        }
    }
}