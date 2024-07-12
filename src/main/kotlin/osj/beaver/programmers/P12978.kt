package osj.beaver.programmers

import kotlin.math.min

class P12978 {
    companion object {

        private lateinit var roadMap: HashMap<Int, IntArray>
        private lateinit var minTime: HashMap<Int, Int>
        private var k = 0

        fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
            roadMap = hashMapOf()
            minTime = hashMapOf()
            this.k = k

            repeat(n) {
                roadMap[it + 1] = IntArray(n + 1)
            }

            for (i in road.indices) {
                val route = road[i]
                val a = route[0]
                val b = route[1]
                val time = route[2]

                if (roadMap[a] == null || roadMap[b] == null) {
                    continue
                }

                val tmpA = roadMap[a]!![b]
                if (tmpA == 0) {
                    roadMap[a]!![b] = time
                } else {
                    roadMap[a]!![b] = time.coerceAtMost(tmpA)
                }


                val tmpB = roadMap[b]!![a]
                if (tmpB == 0) {
                    roadMap[b]!![a] = time
                } else {
                    roadMap[b]!![a] = time.coerceAtMost(tmpB)
                }

            }

            dfs(n, 1, 0)

            return minTime.size
        }

        private fun dfs(n: Int, town: Int, time: Int) {
            if (time > k) return

            val path = roadMap[town] ?: return
            minTime[town] = min(time, minTime.getOrDefault(town, time))

            for (i in 2 .. n) {
                if (path[i] != 0 && time + path[i] < minTime.getOrDefault(i, Int.MAX_VALUE)) {
                    dfs(n, i, time + path[i])
                }
            }
        }
    }
}

fun main() {
    val n = intArrayOf(
        5,
        6,
    )
    val road = listOf(
        arrayOf(
            intArrayOf(1,2,1),
            intArrayOf(2,3,3),
            intArrayOf(5,2,2),
            intArrayOf(1,4,2),
            intArrayOf(5,3,1),
            intArrayOf(5,4,2),
        ),
        arrayOf(
            intArrayOf(1,2,1),
            intArrayOf(1,3,2),
            intArrayOf(2,3,2),
            intArrayOf(3,4,3),
            intArrayOf(3,5,2),
            intArrayOf(3,5,3),
            intArrayOf(5,6,1),
        )
    )
    val k = intArrayOf(
        3,
        4,
    )

    for (i in n.indices) {
        println(P12978.solution(n[i], road[i], k[i]))
    }
}