package osj.beaver.programmers

class P77484 {
    companion object {
        fun solution(lotto: IntArray, winNums: IntArray): IntArray {
            return winNums.count { lotto.filter { lottoNumber -> lottoNumber != 0 }.contains(it) }.let {
                val unknown = lotto.count { number -> number == 0 }
                val max = (7 - (it + unknown)).let { max -> if (max == 7) 6 else max }
                val min = (7 - it).let { min -> if (min == 7) 6 else min }
                intArrayOf(max, min)
            }
        }
    }
}

fun main() {
    val lotto = listOf(
        intArrayOf(44,1,0,0,31,25),
        intArrayOf(0,0,0,0,0,0),
        intArrayOf(45,4,35,20,3,9),
    )

    val winNums = listOf(
        intArrayOf(31,10,45,1,6,19),
        intArrayOf(38, 19, 20, 40, 15, 25),
        intArrayOf(20, 9, 3, 45, 4, 35),
    )

    for (i in lotto.indices) {
        P77484.solution(lotto[i], winNums[i]).forEach { print("$it, ") }
        println()
    }
}