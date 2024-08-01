package osj.beaver.programmers

import kotlin.math.pow
import kotlin.math.sqrt

class P140107 {
    companion object {
        fun solution(k: Int, d: Int): Long {
            var count = 0L
            for (i in 0 .. d step k) {
                val tmp = sqrt(d.toDouble().pow(2.0) - i.toDouble().pow(2.0)) / k + 1
                count += tmp.toLong()
            }

            return count
        }


        @Suppress("Unused")
        // 시간 초과...
        fun solution1(k: Int, d: Int): Long {

            var count: Long = 0
            for (i in 0 .. d step k) {
                for (j in 0 .. d step k) {
                    if (sqrt(i*i.toDouble() + j*j.toDouble()) <= d) {
                        count++
                    }
                }
            }
            return count
        }
    }
}

fun main() {
    val k = intArrayOf(2,1)
    val d = intArrayOf(4,5)

    for (i in k.indices) {
        println(P140107.solution(k[i], d[i]))
    }
}