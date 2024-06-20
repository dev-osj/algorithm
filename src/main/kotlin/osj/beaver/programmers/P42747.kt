package osj.beaver.programmers

class P42747 {

    companion object {
        fun solution(citations: IntArray): Int {
            return citations.sortedDescending()
                .withIndex().firstOrNull {
                    it.value <= it.index
                }?.index ?: citations.size
        }
    }
}

fun main() {
    println(P42747.solution(intArrayOf(3, 0, 6, 1, 5)))
}