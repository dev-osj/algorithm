package osj.beaver.programmers

import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

class P181187 {

    companion object {
        fun solution(r1: Int, r2: Int): Long {
            var answer = 0L
            for (i in 1 .. r2) {
                val tmp2 = sqrt(r2.toDouble().pow(2) - i.toDouble().pow(2)).toLong()
                val tmp1 = ceil(sqrt(r1.toDouble().pow(2) - i.toDouble().pow(2))).toLong()
                answer +=  tmp2 - tmp1 + 1
            }
            return answer * 4
        }
    }
}

fun main() {
    println(P181187.solution(2, 3))
}