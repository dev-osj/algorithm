package osj.beaver.programmers

import java.util.PriorityQueue
import java.util.LinkedList

class P131130 {
    companion object {
        fun solution(cards: IntArray): Int {
            val priorityQueue = PriorityQueue<Int>(reverseOrder())
            val visit = BooleanArray(cards.size)
            for (i in cards.indices) {
                if (!visit[i]) {
                    priorityQueue.offer(bfs(cards, visit, i))
                }
            }

            if (priorityQueue.size < 2) {
                return 0
            }

            return priorityQueue.poll() * priorityQueue.poll()
        }

        private fun bfs(cards: IntArray, visit: BooleanArray, index: Int): Int {
            val queue = LinkedList<Int>()
            queue.add(cards[index])
            visit[index] = true

            var count = 1
            while (queue.isNotEmpty()) {
                val current = queue.poll() - 1
                if (visit[current]) {
                    continue
                }

                queue.add(cards[current])
                visit[current] = true
                count++
            }
            return count
        }
    }
}

fun main() {
    println(P131130.solution(intArrayOf(8,6,3,7,2,5,1,4)))
}