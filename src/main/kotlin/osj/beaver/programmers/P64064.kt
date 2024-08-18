package osj.beaver.programmers

class P64064 {
    companion object {

        fun solution(userId: Array<String>, bannedId: Array<String>): Int {
            val set = HashSet<String>()

            dfs(userId, bannedId, BooleanArray(userId.size), 0, "", set)

            return set.size
        }

        private fun dfs(userId: Array<String>, bannedId: Array<String>, visit: BooleanArray, depth: Int, result: String, set: HashSet<String>) {
            if (depth == bannedId.size) {
                set.add(result.split(" ").sorted().joinToString(""))
                return
            }

            for (i in userId.indices) {
                if (!visit[i] && userId[i].isMatch(bannedId[depth])) {
                    visit[i] = true
                    dfs(userId, bannedId, visit, depth + 1, result + " ${userId[i]}", set)
                    visit[i] = false
                }
            }
        }


        private fun String.isMatch(bannedId: String): Boolean {
            if (this.length != bannedId.length) {
                return false
            }

            for (i in bannedId.indices) {
                if (bannedId[i] == '*') {
                    continue
                }

                if (this[i] != bannedId[i]) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
    val userId = listOf(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    )

    val bannedId = listOf(
        arrayOf("fr*d*", "abc1**"),
        arrayOf("*rodo", "*rodo", "******"),
        arrayOf("fr*d*", "*rodo", "******", "******")
    )

    for (i in userId.indices) {
        println(P64064.solution(userId[i], bannedId[i]))
    }
}