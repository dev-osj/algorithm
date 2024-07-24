package osj.beaver.programmers

import java.util.LinkedList

class P169199 {
    companion object {
        fun solution(board: Array<String>): Int {
            var x: Int = -1
            var y: Int = -1

            board.forEachIndexed { index, s ->
                val yIndex = s.indexOf('R')
                if (yIndex != -1) {
                    x = index
                    y = yIndex
                }
            }

            return bfs(board, Array(board.size) { BooleanArray(board[0].length) }, x, y)
        }

        private fun bfs(board: Array<String>, visit: Array<BooleanArray>, x: Int, y: Int): Int {
            val queue = LinkedList<Triple<Int, Int, Int>>()
            visit[x][y] = true
            queue.add(Triple(x, y, 0))

            val upDown = intArrayOf(-1, 1, 0, 0)
            val leftRight = intArrayOf(0, 0, -1, 1)

            while (queue.isNotEmpty()) {
                val current = queue.pop()

                if (board[current.first][current.second] == 'G') {
                    return current.third
                }

                repeat(4) {
                    var newX = current.first + upDown[it]
                    var newY = current.second + leftRight[it]

                    while(true) {
                        if (newX in board.indices && newY in 0 until board[0].length && board[newX][newY] != 'D') {
                            newX += upDown[it]
                            newY += leftRight[it]
                        } else {
                            newX -= upDown[it]
                            newY -= leftRight[it]
                            break
                        }
                    }

                    if (!visit[newX][newY]) {
                        visit[newX][newY] = true
                        queue.add(Triple(newX, newY, current.third + 1))
                    }
                }
            }
            return -1
        }
    }
}

fun main() {
    val board = arrayOf(
        arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D...."),
        arrayOf(".D.R", "....", ".G..", "...D")
    )

    board.forEach {
        println(P169199.solution(it))
    }
}