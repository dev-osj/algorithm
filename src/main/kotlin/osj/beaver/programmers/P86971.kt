package osj.beaver.programmers

class P86971 {
    companion object {
        private lateinit var network: Array<MutableList<Int>>
        private lateinit var visit: BooleanArray

        fun solution(n: Int, wires: Array<IntArray>): Int {
            network = Array(n + 1) { mutableListOf() }
            wires.forEach {
                network[it[0]].add(it[1])
                network[it[1]].add(it[0])
            }

            var min = Int.MAX_VALUE
            wires.forEach {
                network[it[0]].remove(it[1])
                network[it[1]].remove(it[0])

                visit = BooleanArray(n + 1)

                val count = dfs(1)
                min = Math.abs(count - (n - count)).coerceAtMost(min)

                network[it[0]].add(it[1])
                network[it[1]].add(it[0])
            }
            return min
        }

        private fun dfs(position: Int): Int {
            visit[position] = true

            var count = 1
            network[position].forEach {
                if (!visit[it]) {
                    count += dfs(it)
                }
            }
            return count
        }
    }
}

fun main() {
    val n = intArrayOf(9,4,7)

    val wires = listOf(
        arrayOf(
            intArrayOf(1,3),
            intArrayOf(2,3),
            intArrayOf(3,4),
            intArrayOf(4,5),
            intArrayOf(4,6),
            intArrayOf(4,7),
            intArrayOf(7,8),
            intArrayOf(7,9),
        ),
        arrayOf(
            intArrayOf(1,2),
            intArrayOf(2,3),
            intArrayOf(3,4),
        ),
        arrayOf(
            intArrayOf(1,2),
            intArrayOf(2,7),
            intArrayOf(3,7),
            intArrayOf(3,4),
            intArrayOf(4,5),
            intArrayOf(6,7),
        )
    )

    for (i in n.indices) {
        println(P86971.solution(n[i], wires[i]))
    }
}