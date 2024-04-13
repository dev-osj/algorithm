package osj.beaver.baekjoon.combinatorics

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    writer.write("${n * (n - 1)}")
    writer.flush()
    writer.close()
}
/*
1. 0 = 1 x 0
2. 2 = 2 x 1
3. 6 = 3 x 2
4. 12 = 4 x 3
...
 */