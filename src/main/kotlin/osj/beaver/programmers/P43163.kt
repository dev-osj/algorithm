package osj.beaver.programmers

class P43163 {
    companion object {
        private var min = 51
        private var indexMap = hashMapOf<String, Int>()

        fun solution(begin: String, target: String, words: Array<String>): Int {
            if (!words.contains(target)) {
                return 0
            }

            words.forEachIndexed { index, s ->
                indexMap[s] = index
            }

            dfs(words, BooleanArray(words.size), target, begin, 0)

            return min
        }

        private fun dfs(words: Array<String>, visit: BooleanArray, target: String, current: String, count: Int) {
            if(current == target) {
                min = min.coerceAtMost(count)
                return
            }

            words.forEach {
                val wordIndex = indexMap[it]
                if (wordIndex != null && !visit[wordIndex] && current.isOneLetterDiffer(it)) {
                    visit[wordIndex] = true
                    dfs(words, visit, target, it, count + 1)
                    visit[wordIndex] = false
                }
            }


        }

        private fun String.isOneLetterDiffer(str2: String): Boolean {
            var differCount = 0
            for (i in this.indices) {
                if (this[i] != str2[i]) {
                    differCount++
                    if (differCount > 1) {
                        return false
                    }
                }
            }
            return true
        }
    }
}

fun main() {
    val begin = listOf("hit", "hit")
    val target = listOf("cog", "cog")
    val words = listOf(
        arrayOf("hot", "dot", "dog", "lot", "log", "cog"),
        arrayOf("hot", "dot", "dog", "lot", "log"),
    )

    for (i in begin.indices) {
        println(P43163.solution(begin[i], target[i], words[i]))
    }
}