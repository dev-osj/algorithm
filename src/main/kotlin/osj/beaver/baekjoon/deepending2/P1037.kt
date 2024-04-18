package osj.beaver.baekjoon.deepending2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.SortedSet
import java.util.StringTokenizer

// 116ms 18668kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val count = reader.readLine().toInt()
    val set: SortedSet<Int> = sortedSetOf<Int>()

    val stringTokenizer = StringTokenizer(reader.readLine())
    repeat(count) {
        set.add(stringTokenizer.nextToken().toInt())
    }

    println(set.last() * set.first())
}

/*
1 2 4 8
2 * 4 = 8

1 2 3 4 6 8 12 14
2 * 12 = 24

1 2 3 6
2 * 3 = 6

1 2 5 10
5 * 2 = 10

1 3 9
3 * 3 = 9

1 2 4
2 * 2 = 4
 */