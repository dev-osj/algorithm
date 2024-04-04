package osj.beaver.baekjoon.bruteforce

import java.util.StringTokenizer

// 132ms 12956kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val a = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()
    val c = stringTokenizer.nextToken().toInt()
    val d = stringTokenizer.nextToken().toInt()
    val e = stringTokenizer.nextToken().toInt()
    val f = stringTokenizer.nextToken().toInt()

    for (i in -999 .. 999) {
        for (j in -999 .. 999) {
            val func1 = a*i + b*j
            val func2 = d*i + e*j

            if (func1 == c && func2 == f) {
                println("$i $j")
            }
        }
    }
}