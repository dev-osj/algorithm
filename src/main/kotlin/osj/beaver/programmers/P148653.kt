package osj.beaver.programmers

class P148653 {

    companion object {
        var result = 0
        fun solution(storey: Int): Int {
            val length = storey.toString().length
            dfs(storey, length, 0)
            return result
        }

        private fun dfs(storey: Int, depth: Int, count: Int) {
            if (depth < 0) {
                result = count
                return
            }

            val mod = storey % 10
            val nextMod = storey / 10 % 10

            if (mod > 5 || (mod == 5 && nextMod >= 5)) {
                dfs((storey + 10) / 10, depth - 1, count + (10 - mod))
            } else {
                dfs(storey / 10, depth - 1, count + mod)
            }
        }
    }
}

fun main() {
    val storey = intArrayOf(
        16,
        2554,
        485, // 첫 시도 반례
    )

    storey.forEach { println(P148653.solution(it)) }
}