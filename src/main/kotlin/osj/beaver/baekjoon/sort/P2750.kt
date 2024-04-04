package osj.beaver.baekjoon.sort

import java.util.StringTokenizer

// 172ms 14816kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()
    val array = BooleanArray(2001) { false }

    repeat(n) {
        stringTokenizer = StringTokenizer(readln())
        val number = stringTokenizer.nextToken().toInt() + 1000
        array[number] = true
    }

    array.forEachIndexed { index, b ->
        if (b) {
            println(index - 1000)
        }
    }
}