package osj.beaver.programmers

class P159994 {
    companion object {
        fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
            var index1 = 0
            var index2 = 0
            goal.forEach {
                if (index1 < cards1.size && it == cards1[index1]) {
                    index1++
                    return@forEach
                }

                if (index2 < cards2.size && it == cards2[index2]) {
                    index2++
                    return@forEach
                }
                return "No"
            }
            return "Yes"
        }
    }
}

fun main() {
    val cards1 = listOf(
        arrayOf("i", "drink", "water"),
        arrayOf("i", "water", "drink")
    )

    val cards2 = listOf(
        arrayOf("want", "to"),
        arrayOf("want", "to"),
    )

    val goal = listOf(
        arrayOf("i", "want", "to", "drink", "water"),
        arrayOf("i", "want", "to", "drink", "water"),
    )

    cards1.forEachIndexed { index, strings ->
        println(P159994.solution(strings, cards2[index], goal[index]))
    }
}