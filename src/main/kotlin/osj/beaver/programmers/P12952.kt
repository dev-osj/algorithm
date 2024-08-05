package osj.beaver.programmers

import kotlin.math.abs

class P12952 {
    companion object {

        var count = 0

        fun solution(n: Int): Int {
            dfs(n, 0, IntArray(n))
            return count
        }

        private fun dfs(n: Int, depth: Int, array: IntArray) {
            if (n == depth) {
                count++
                return
            }

            for (y in 0 until n) {
                var result = true
                for (x in 0 until depth) {
                    if (y == array[x] || abs(array[x] - y) == depth - x) {
                        result = false
                        break
                    }
                }

                if (result) {
                    array[depth] = y
                    dfs(n, depth + 1, array)
                }
            }
        }
    }
}

fun main() {
    println(P12952.solution(4))
}