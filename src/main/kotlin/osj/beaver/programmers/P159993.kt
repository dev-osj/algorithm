package osj.beaver.programmers

import java.util.LinkedList

class P159993 {
    companion object {

        lateinit var map: Array<String>

        fun solution(maps: Array<String>): Int {
            map = maps

            val start = findTarget('S')
            val leverTime = bfs(start, 'L')
            if (leverTime == -1) {
                return -1
            }

            val lever = findTarget('L')
            val exitTime = bfs(lever, 'E')
            if (exitTime == -1) {
                return -1
            }

            return leverTime + exitTime
        }

        private fun findTarget(target: Char): Triple<Int, Int, Int> {
            map.forEachIndexed { index, s ->
                val yStart = s.indexOf(target)
                if (yStart != -1) {
                    return Triple(index, yStart, 0)
                }
            }
            return Triple(-1, -1, 0)
        }

        private fun bfs(point: Triple<Int, Int, Int>, target: Char): Int {
            val queue = LinkedList<Triple<Int, Int, Int>>()
            queue.add(point)

            val visit = Array(map.size) { BooleanArray(map[0].length) }
            visit[point.first][point.second] = true

            while (queue.isNotEmpty()) {
                val now = queue.poll()

                if (map[now.first][now.second] == target) {
                    return now.third
                }

                val upDown = intArrayOf(1, -1, 0, 0)
                val leftRight = intArrayOf(0, 0, 1, -1)

                for (i in 0 until 4) {
                    val newX = now.first + upDown[i]
                    val newY = now.second + leftRight[i]

                    if (newX !in map.indices || newY !in 0 until map[0].length) {
                        continue
                    }

                    if (map[newX][newY] == 'X') {
                        continue
                    }

                    if (visit[newX][newY]) {
                        continue
                    }

                    visit[newX][newY] = true
                    queue.add(Triple(newX, newY, now.third + 1))
                }

            }
            return -1
        }
    }
}

fun main() {
    val maps = arrayOf(
        arrayOf("SOOOOL", "XXXXXO", "OOOOOO", "OXXXXX", "OOOOOE"),
        arrayOf("LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO")
    )

    maps.forEach {
        println(P159993.solution(it))
    }
}