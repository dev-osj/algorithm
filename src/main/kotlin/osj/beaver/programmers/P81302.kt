package osj.beaver.programmers

import java.util.LinkedList
import kotlin.math.abs

class P81302 {
    companion object {

        private val upDown = intArrayOf(-1, 1, 0, 0)
        private val leftRight = intArrayOf(0, 0, -1, 1)

        fun solution(places: Array<Array<String>>): IntArray {
            val result = IntArray(places.size)

            places.forEachIndexed { index, strings ->

                var exists = 1

                for (i in 0 .. 4) {
                    for (j in 0 .. 4) {
                        if (strings[i][j] == 'P') {
                            val bfs = bfs(strings, i, j)
                            if (bfs == 0) {
                                exists = 0
                            }
                        }
                    }
                }
                result[index] = exists
            }

            return result
        }

        private fun bfs(places: Array<String>, x: Int, y: Int): Int {
            val queue = LinkedList<Pair<Int, Int>>()
            queue.offer(Pair(x, y))

            while (queue.isNotEmpty()) {
                val current = queue.poll()

                for (i in 0 until 4) {
                    val newX = current.first + upDown[i]
                    val newY = current.second + leftRight[i]

                    if (
                        newX !in 0 .. 4 ||
                        newY !in 0 .. 4 ||
                        (newX == x && newY == y)
                    ) {
                        continue
                    }

                     if(places[newX][newY] == 'X') {
                         continue
                     }

                    val direction = abs(newX - x) + abs(newY - y)
                    if (direction <= 2 && places[newX][newY] == 'P') {
                        return 0
                    }

                    if (direction < 2) {
                        queue.offer(Pair(newX, newY))
                    }
                }
            }
            return 1
        }
    }
}

fun main() {
    val places = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
    )

    P81302.solution(places).forEach {
        print("$it ")
    }
}