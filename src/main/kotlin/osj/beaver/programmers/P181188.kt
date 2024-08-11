package osj.beaver.programmers

class P181188 {
    companion object {
        fun solution(targets: Array<IntArray>): Int {
            targets.sortBy { it[1] }

            var current = 0
            var result = 0

            for (i in targets.indices) {
                if (current <= targets[i][0]) {
                    current = targets[i][1]
                    result++
                }
            }

            return result
        }
    }
}

fun main() {
    println(
        P181188.solution(
            arrayOf(
                intArrayOf(4,5),
                intArrayOf(4,8),
                intArrayOf(10,14),
                intArrayOf(11,13),
                intArrayOf(5,12),
                intArrayOf(3,7),
                intArrayOf(1,4),
            )
        )
    )
}