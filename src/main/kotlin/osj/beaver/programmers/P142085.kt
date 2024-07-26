package osj.beaver.programmers

import java.util.PriorityQueue

class P142085 {
    companion object {
        fun solution(n: Int, k: Int, enemy: IntArray): Int {
            if (enemy.size == k) {
                return k
            }

            var result = 0
            var life = n
            val queue = PriorityQueue<Int>()
            for(i in enemy.indices) {
                 if (k > i) {
                     queue.add(enemy[i])
                     result++
                     continue
                 }

                 var attack = enemy[i]
                 if (queue.peek() < attack) {
                     queue.add(attack)
                     attack = queue.poll()
                 }

                 if (life >= attack) {
                     life -= attack
                 }else {
                     return result
                 }
                 result++
             }
            return result
        }
    }
}

fun main() {
    val n = intArrayOf(7,2)
    val k = intArrayOf(3,4)
    val enemy = arrayOf(
        intArrayOf(4,2,4,5,4,3,3,1),
        intArrayOf(3,3,3,3),
    )

    for (i in n.indices) {
        println(P142085.solution(n[i], k[i], enemy[i]))
    }
}