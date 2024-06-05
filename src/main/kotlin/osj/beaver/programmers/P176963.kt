package osj.beaver.programmers

class P176963 {
    companion object {
        fun solution(names: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
            val nameScoreMap = names.zip(yearning.toTypedArray()).toMap()
            val result = IntArray(photo.size)
            repeat(photo.size) { index ->
                var score = 0
                photo[index].forEach {
                    score += nameScoreMap.getOrDefault(it, 0)
                }
                result[index] = score
            }

            return result
        }
    }
}

fun main() {
    P176963.solution(
        arrayOf("may", "kein", "kain", "radi"),
        intArrayOf(5, 10, 1, 3),
        arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni"),
        )
    ).forEach {
        println("$it, ")
    }
}