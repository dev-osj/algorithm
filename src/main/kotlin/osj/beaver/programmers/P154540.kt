package osj.beaver.programmers

class P154540 {
    companion object {
        fun solution(maps: Array<String>): IntArray {
            val intMap = initMap(maps)
            val visit = Array (intMap.size) {BooleanArray(intMap[0].size)}
            val result = mutableListOf<Int>()

            for (i in intMap.indices) {
                for (j in intMap[i].indices) {
                    if(!visit[i][j] && intMap[i][j] != 0) {
                        val sum = dfs(intMap, visit, i, j, 0)
                        if (sum != 0) {
                            result.add(sum)
                        }
                    }
                }
            }

            result.sort()

            if (result.isEmpty()) {
                result.add(-1)
            }

            return result.toIntArray()
        }

        private fun initMap(maps: Array<String>): Array<IntArray> {
            val intMaps = Array(maps.size) {IntArray(maps[0].length)}
            maps.forEachIndexed { i, s ->
                s.forEachIndexed { j, c ->
                    if (c != 'X') {
                        intMaps[i][j] = c.digitToInt()
                    } else {
                        intMaps[i][j] = 0
                    }
                }
            }

            return intMaps
        }

        private fun dfs(map: Array<IntArray>, visit: Array<BooleanArray>, x: Int, y: Int, day: Int): Int {
            var result = day + map[x][y]
            visit[x][y] = true
            val upDown = intArrayOf(-1, 1, 0, 0)
            val leftRight = intArrayOf(0, 0, -1, 1)

            for (i in upDown.indices) {
                val nextX = x + leftRight[i]
                val nextY = y + upDown[i]

                if (nextX !in map.indices || nextY !in 0 until map[0].size) {
                    continue
                }

                if (map[nextX][nextY] != 0 && !visit[nextX][nextY]) {
                    result = dfs(map, visit, nextX, nextY, result)
                }

            }

            return result
        }
    }
}

fun main() {
    val maps = arrayOf(
        arrayOf("X591X", "X1X5X", "X231X", "1XXX1"),
        arrayOf("XXX","XXX","XXX"),
    )

    maps.forEach { it ->
        P154540.solution(it).forEach {
            print("$it ")
        }
        println()
    }
}