package osj.beaver.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.system.exitProcess

// 364ms 16912kb
class P14889(val n: Int) {
    lateinit var people: Array<IntArray>
    lateinit var visit: BooleanArray
    var min = Int.MAX_VALUE

    fun dfs(start: Int, depth: Int) {
        if (depth == n / 2) {
            var teamStart = 0
            var teamLink = 0
            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    if (visit[i] && visit[j]) {
                        teamStart += (people[i][j] + people[j][i])
                    } else if (!visit[i] && !visit[j]) {
                        teamLink += (people[i][j] + people[j][i])
                    }
                }
            }
            val result = abs(teamStart - teamLink)
            if (result == 0) {
                println(result)
                exitProcess(0)
            }

            min = min.coerceAtMost(result)
            return
        }

        for (i in start until n) {
            if (!visit[i]) {
                visit[i] = true
                dfs(i + 1, depth + 1)
                visit[i] = false
            }
        }
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val p14889 = P14889(n)
    p14889.people = Array(n) { IntArray(n) }
    p14889.visit = BooleanArray(n)

    var stringTokenizer: StringTokenizer
    for (i in 0 until n) {
        stringTokenizer = StringTokenizer(reader.readLine())
        for (j in 0 until n) {
            p14889.people[i][j] = stringTokenizer.nextToken().toInt()
        }
    }
    p14889.dfs(0, 0)
    println(p14889.min)
}

