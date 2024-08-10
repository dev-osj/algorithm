package osj.beaver.programmers

class P150368 {
    companion object {

        private lateinit var prices: IntArray
        private lateinit var sales: IntArray
        private var maxPlus = 0
        private var maxSum = 0

        fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
            prices = IntArray(emoticons.size)
            sales = IntArray(emoticons.size)

            dfs(users, emoticons, emoticons.size, 0)

            return intArrayOf(maxPlus, maxSum)
        }

        private fun dfs(users: Array<IntArray>, emoticons: IntArray, n: Int, depth: Int) {
            if (n == depth) {
                for(i in emoticons.indices) {
                    prices[i] = emoticons[i] * (100 - sales[i]) / 100
                }

                var plus = 0
                var totalSum = 0
                for (i in users.indices) {
                    var sum = 0
                    for (j in emoticons.indices) {
                        if (sales[j] >= users[i][0]) {
                            sum += prices[j]
                        }

                        if (sum >= users[i][1]) {
                            sum = -1
                            break
                        }
                    }
                    if (sum == -1) {
                        plus++
                    } else {
                        totalSum += sum
                    }
                }

                if (plus > maxPlus) {
                    maxPlus = plus
                    maxSum = totalSum
                }

                if (plus == maxPlus && maxSum < totalSum) {
                    maxSum = totalSum
                }

                return
            }

            for (i in 10 .. 40 step 10) {
                sales[depth] = i
                dfs(users, emoticons, n, depth + 1)
            }

        }
    }
}

fun main() {
    val users = listOf(
        arrayOf(
            intArrayOf(40, 10000),
            intArrayOf(25, 10000),
        ),
        arrayOf(
            intArrayOf(40, 2900),
            intArrayOf(23, 10000),
            intArrayOf(11, 5200),
            intArrayOf(5, 5900),
            intArrayOf(40, 3100),
            intArrayOf(27, 9200),
            intArrayOf(32, 6900),
        )
    )

    val emoticons = listOf(
        intArrayOf(7000, 9000),
        intArrayOf(1300, 1500, 1600, 4900),
    )

    for (i in users.indices) {
        P150368.solution(users[i], emoticons[i]).forEach {
            print("$it ")
        }
        println()
    }
}