package osj.beaver.programmers

class P160586 {
    companion object {
        fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
            val minMap = hashMapOf<Char, Int>()
            keymap.forEach { keys ->
                val split = keys.toCharArray()
                split.forEachIndexed { index, key ->
                    minMap[key] = Math.min(minMap.getOrDefault(key, index + 1), index + 1)
                }
            }

            val result = IntArray(targets.size)
            for (i in targets.indices) {
                val target = targets[i].toCharArray()
                var sum = 0
                for (j in target.indices) {
                    if (minMap[target[j]] == null) {
                        result[i] = -1
                        break
                    }
                    sum += minMap[target[j]]!!
                }

                if (result[i] != -1) {
                    result[i] = sum
                }
            }

            return result
        }

        @Suppress("Unused")
        fun solution2(keymap: Array<String>, targets: Array<String>): IntArray =
            keymap.flatMap { it.mapIndexed { index, char -> char to index + 1 } }
                .groupBy { it.first }
                .map { it.key to it.value.minOf { value -> value.second } }.toMap()
                .let { map ->
                    targets.map { target -> target.sumOf { char -> map[char] ?: 10001 } }
                }.map { if (it >= 10001) -1 else it }
                .toIntArray()
    }
}

fun main() {
    val keymap = listOf(
        arrayOf("ABACD", "BCEFD"),
        arrayOf("AA"),
        arrayOf("AGZ", "BSSS"),
        arrayOf("ABACD", "BCEFD")
    )

    val target = listOf(
        arrayOf("ABCD", "AABB"),
        arrayOf("B"),
        arrayOf("ASA", "BGZ"),
        arrayOf("DG"),
    )

    keymap.forEachIndexed { index, strings ->
        P160586.solution(strings, target[index]).forEach { print("$it, ") }
        println()
    }
}