package osj.beaver.programmers

class P43162 {
    companion object {
         fun solution(n: Int, computers: Array<IntArray>): Int {
             val visit = BooleanArray(n)
             var result = 0
             repeat(n) {
                 if (!visit[it]) {
                     dfs(computers, visit, it)
                     result++
                 }
             }
             return result
         }

        private fun dfs(computers: Array<IntArray>, visit: BooleanArray, current: Int) {
            visit[current] = true
            for (i in computers[current].indices) {
                if (!visit[i] && computers[current][i] != 0) {
                    dfs(computers, visit, i)
                }
            }
        }
    }
}

fun main() {
    val n = intArrayOf(3,3)
    val computers = listOf(
        arrayOf(
            intArrayOf(1,1,0),
            intArrayOf(1,1,0),
            intArrayOf(0,0,1),
        ),
        arrayOf(
            intArrayOf(1,1,0),
            intArrayOf(1,1,1),
            intArrayOf(0,1,1),
        )
    )

    for (i in n.indices) {
        println(P43162.solution(n[i], computers[i]))
    }
}