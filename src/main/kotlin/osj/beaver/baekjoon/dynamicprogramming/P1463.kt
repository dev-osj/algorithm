package osj.beaver.baekjoon.dynamicprogramming


// 120ms 17044kb
fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 0
    for (i in 2 .. n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) {
            dp[i] = dp[i].coerceAtMost(dp[i / 2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = dp[i].coerceAtMost(dp[i / 3] + 1)
        }
    }
    println(dp[n])
}

// 248ms 71516kb
@Suppress("Unused")
fun firstTry() {
    val n = readln().toInt()
    val dp = Array<Int?>(size = n + 1) { null }
    dp[0] = 0
    dp[1] = 0
    println(p1463(dp, n))
}

fun p1463(dp: Array<Int?>, value: Int): Int {
    if (dp[value] == null) {
        if (value % 6 == 0) {
            dp[value] = p1463(dp, value / 2)
                .coerceAtMost(p1463(dp, value / 3))
                .coerceAtMost(p1463(dp, value - 1)) + 1
        } else if (value % 3 == 0) {
            dp[value] = p1463(dp, value - 1).coerceAtMost(p1463(dp, value / 3)) + 1
        } else if (value % 2 == 0) {
            dp[value] = p1463(dp, value - 1).coerceAtMost(p1463(dp, value / 2)) + 1
        } else {
            dp[value] = p1463(dp, value - 1) + 1
        }
    }

    return dp[value] ?: 0
}