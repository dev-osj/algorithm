package osj.beaver.programmers

class P161989 {
    companion object {
        fun solution(n: Int, m: Int, section: IntArray): Int {
            if (n == m) {
                return 1
            }

            var number = section[0]
            var count = 1
            for (i in 1 until section.size) {
                val limit = number + m - 1
                if (section[i] > limit) {
                    count++
                    number = section[i]
                }
            }

            return count
        }
    }
}

fun main() {
    val n = intArrayOf(8, 5, 4, 16, 5)
    val m = intArrayOf(4, 4, 1, 4, 2)
    val section = listOf(
        intArrayOf(2, 3, 6),
        intArrayOf(1, 3),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(2, 6, 15, 16),
        intArrayOf(1,4,5),
    )

    n.forEachIndexed { index, i ->
        println(P161989.solution(n[index], m[index], section[index]))
    }
}