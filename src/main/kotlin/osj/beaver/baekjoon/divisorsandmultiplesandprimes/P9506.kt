package osj.beaver.baekjoon.divisorsandmultiplesandprimes

import java.util.StringTokenizer

// 144ms 21096kb
fun main() {
    while(true) {
        val stringTokenizer = StringTokenizer(readln())
        val n = stringTokenizer.nextToken().toInt()

        if(n == -1) {
            break
        }

        val array = mutableListOf<Int>()
        for (i in 1 .. Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                array.add(i)
                if (i != n / i) {
                    array.add(n / i)
                }
            }
        }

        array.sort()
        array.removeLast()

        if (array.sum() == n) {
            println("$n = ${array.joinToString(" + ")}")
        } else {
            println("$n is NOT perfect.")
        }
    }
}