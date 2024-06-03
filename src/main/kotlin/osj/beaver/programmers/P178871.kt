package osj.beaver.programmers

class P178871 {

    companion object {
        fun solution(players: Array<String>, callings: Array<String>): Array<String> {
            val playerMap = hashMapOf<String, Int>()
            val rankMap = hashMapOf<Int, String>()

            players.forEachIndexed { index, player ->
                playerMap[player] = index
                rankMap[index] = player
            }

            callings.forEach {
                val callPlayerRank = playerMap[it]
                val frontPlayerRank = rankMap[callPlayerRank!! - 1]!!

                playerMap[it] = callPlayerRank - 1
                playerMap[frontPlayerRank] = callPlayerRank
                rankMap[callPlayerRank - 1] = it
                rankMap[callPlayerRank] = frontPlayerRank
            }

            return Array(players.size) { i -> rankMap[i]!! }
        }
    }
}

fun main() {
    P178871.solution(
        arrayOf("mumu", "soe", "poe", "kai", "mine"),
        arrayOf("kai", "kai", "mine", "mine")
    ).forEach {
        print("$it, ")
    }
}