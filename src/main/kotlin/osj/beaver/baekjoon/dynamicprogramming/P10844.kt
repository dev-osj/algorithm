package osj.beaver.baekjoon.dynamicprogramming

// 92ms 12364kb
fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { LongArray(10) }

    for (i in 1 .. 9) {
        dp[1][i] = 1
    }

    for (i in 2 .. n) {
        for (j in 0 .. 9) {
            if (j == 0) {
                dp[i][0] = dp[i - 1][1] % 1000000000
            } else if (j == 9) {
                dp[i][9] = dp[i - 1][8] % 1000000000
            } else {
                dp[i][j] = (dp[i - 1][j - 1] % 1000000000 + dp[i - 1][j + 1] % 1000000000) % 1000000000
            }
        }
    }

    var result = 0L
    for (i in 0 .. 9) {
        result += dp[n][i]
    }

    println(result % 1000000000)
}

/*
    0          1              2               3                 4                5                6                7             8              9
1   0          1              2               3                 4                5                6                7             8              9
2   01       10,12          21,23           32,34             43,45            54,56            65,67            76,78         87,89            98
3 10,12   101,121,123  210,212,232,234  321,323,343,345  423,434,454,456  543,545,565,567  654,656,676,678  765,767,787,789  876,878,898     987,989

[i][0] = [i-1][1]
[i][9] = [i-1][8]
[i][j] = [i-1][j-1] + [i-1][j+1]
 */
