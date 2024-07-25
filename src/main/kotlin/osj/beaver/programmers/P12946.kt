package osj.beaver.programmers

class P12946 {
    companion object {

        private lateinit var result: MutableList<IntArray>
        fun solution(n: Int): Array<IntArray> {
            result = mutableListOf()
            hanoi(n, 1,2,3)

            return result.toTypedArray()
        }

        private fun hanoi(k: Int, from: Int, sub: Int, to: Int) {
            if (k == 0) return
            hanoi(k - 1, from, to, sub)
            result.add(intArrayOf(from, to))
            hanoi(k - 1, sub, from, to)
        }
    }
}

fun main() {
    P12946.solution(2).forEach {
        println("${it[0]}, ${it[1]}")
    }
}