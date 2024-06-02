package osj.beaver.programmers


// 가장 많이 받은 선물 문제
class P258712 {
    companion object {
        fun solution(friends: Array<String>, gifts: Array<String>): Int {
            val giftMap: HashMap<String, HashMap<String, Int>> = hashMapOf()
            val scoreMap: HashMap<String, Int> = hashMapOf()

            friends.forEach {
                giftMap[it] = hashMapOf()
                scoreMap[it] = 0
            }

            gifts.forEach {
                val (from, to) = it.split(" ")

                giftMap[from]!![to] = giftMap[from]!!.getOrDefault(to, 0) + 1
                scoreMap[from] = scoreMap.getOrDefault(from, 0) + 1
                scoreMap[to] = scoreMap.getOrDefault(to, 0) - 1
            }

            var max = 0
            val nextGiftMap: HashMap<String, Int> = hashMapOf()
            for (i in friends.indices) {
                for (j in i + 1 until friends.size) {
                    val from = friends[i]
                    val to = friends[j]
                    val giftFrom = giftMap[from]!!.getOrDefault(to, 0)
                    val giftTo = giftMap[to]!!.getOrDefault(from, 0)

                    if (giftFrom > giftTo) {
                        nextGiftMap[from] = nextGiftMap.getOrDefault(from, 0) + 1
                    } else if (giftFrom < giftTo) {
                        nextGiftMap[to] = nextGiftMap.getOrDefault(to, 0) + 1
                    } else if ((scoreMap[from] ?: 0) > (scoreMap[to] ?: 0)) {
                        nextGiftMap[from] = nextGiftMap.getOrDefault(from, 0) + 1
                    } else if ((scoreMap[from] ?: 0) < (scoreMap[to] ?: 0)){
                        nextGiftMap[to] = nextGiftMap.getOrDefault(to, 0) + 1
                    }

                    if ((nextGiftMap[from] ?: 0) > max || (nextGiftMap[to] ?: 0) > max) {
                        max += 1
                    }
                }
            }

            return max
        }
    }
}

fun main() {
    val friends = arrayOf(
        arrayOf("muzi", "ryan", "frodo", "neo"),
        arrayOf("joy", "brad", "alessandro", "conan", "david"),
        arrayOf("a", "b", "c")
    )

    val gifts = arrayOf(
        arrayOf(
            "muzi frodo",
            "muzi frodo",
            "ryan muzi",
            "ryan muzi",
            "ryan muzi",
            "frodo muzi",
            "frodo ryan",
            "neo muzi"
        ),
        arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"),
        arrayOf("a b", "b a", "c a", "a c", "a c", "c a")
    )

    val answer = arrayOf(
        2,
        4,
        0,
    )


    for (i in friends.indices) {
        println(P258712.solution(friends[i], gifts[i]) == answer[i])
    }
}