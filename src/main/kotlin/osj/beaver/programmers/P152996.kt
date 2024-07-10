package osj.beaver.programmers

class P152996 {
    companion object {
        fun solution(weights: IntArray): Long {
            val map = hashMapOf<Int, Int>()
            weights.forEach {
                map[it] = map.getOrDefault(it, 0) + 1
            }

            var answer = 0L
            for (i in weights.indices) {
                map[weights[i]] = map.getOrDefault(weights[i], 1) - 1

                val number = weights[i]

                answer += map.getOrDefault(number, 0)
                answer += map.getOrDefault(number * 2, 0)

                if (number % 4 == 0) {
                    answer += map.getOrDefault(number * 3 / 4, 0)
                }

                if (number % 3 == 0) {
                    answer += map.getOrDefault(number * 4 / 3, 0)
                    answer += map.getOrDefault(number * 2 / 3, 0)
                }

                if (number % 2 == 0) {
                    answer += map.getOrDefault( number * 3 / 2, 0)
                    answer += map.getOrDefault(number / 2, 0)
                }

            }
            return answer
        }
    }
}

fun main() {
    val weights = intArrayOf(100,180,360,100,270)
    println(P152996.solution(weights))
}