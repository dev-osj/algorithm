package osj.beaver.baekjoon.combinatorics

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val k = stringTokenizer.nextToken().toInt()

    println(binomialCoefficient(n, k))
}

fun binomialCoefficient(n: Int, k: Int): Int {
    if (n == k || k == 0) {
        return 1
    }

    return binomialCoefficient(n - 1, k) + binomialCoefficient(n - 1, k - 1)
}

/*
5,2 = 10
5,2 = 4,2 + 4,1 = 10
4,2 = 3,2 + 3,1 = 6
4,1 = 3,1 + 3,0 = 4
3,2 = 2,2 + 2,1 = 3
3,1 = 2,1 + 2,0 = 3
2,2 = 1
2,1 = 1,1 + 1,0 = 2
2,0 = 1
n,k = n-1,k + n-1,k-1
 */