package osj.beaver.programmers

class P72411 {
    companion object {
        lateinit var map: HashMap<Int, HashMap<String, Int>>
        fun solution(orders: Array<String>, course: IntArray): Array<String> {
            map = hashMapOf()
            for (i in orders.indices) {
                val text = orders[i].toCharArray().sorted().joinToString("")
                for (j in course.indices) {
                    map[course[j]] = map.getOrDefault(course[j], hashMapOf())
                    dfs(text, BooleanArray(text.length),0, course[j], "")
                }
            }

            val max = map.mapNotNull { map ->
                if (map.value.isNotEmpty()) {
                    val max = map.value.maxOf { it.value }
                    map.value.entries.filter { it.value > 1 && it.value == max }.map { it.key }
                } else {
                    null
                }
            }.flatten()

            return max.sorted().toTypedArray()
        }

        private fun dfs(order: String, visit: BooleanArray, start: Int, depth: Int, value: String) {
            if (depth == value.length) {
                map[depth]!![value] = map[depth]!!.getOrDefault(value, 0) + 1
                return
            }

            for (i in start until order.length) {
                if (visit[start]) continue

                visit[start] = true
                dfs(order, visit, i+1, depth, value + order[i])
                visit[start] = false
            }
        }
    }
}

fun main() {
    val orders = listOf(
//        arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"),
//        arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"),
        arrayOf("XYZ", "XWY", "WXA"),
    )

    val course = listOf(
//        intArrayOf(2,3,4),
//        intArrayOf(2,3,5),
        intArrayOf(2,3,4),
    )

    for (i in orders.indices) {
        P72411.solution(orders[i], course[i]).forEach { print("$it,") }
        println()
    }
}