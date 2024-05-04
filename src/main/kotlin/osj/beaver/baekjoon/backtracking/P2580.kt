package osj.beaver.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.system.exitProcess

lateinit var board: Array<IntArray>

// 388ms 19780ms
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    board = Array(9) { IntArray(9) }
    var stringTokenizer: StringTokenizer
    for (i in 0 until 9) {
        stringTokenizer = StringTokenizer(reader.readLine())
        for (j in 0 until 9) {
            board[i][j] = stringTokenizer.nextToken().toInt()
        }
    }

    p2580Dfs(0, 0)
}

fun p2580Dfs(x: Int, y: Int) {
    if (y == 9) {
        p2580Dfs(x+1, 0)
        return
    }

    if (x == 9) {
        val stringBuilder = StringBuilder()
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                stringBuilder.append("${board[i][j]} ")
            }
            stringBuilder.appendLine()
        }
        println(stringBuilder)
        exitProcess(0)
    }

    if (board[x][y] == 0) {
        for (i in 1 .. 9) {
            if (p2580Check(x,y,i)) {
                board[x][y] = i
                p2580Dfs(x, y + 1)
            }
        }
        board[x][y] = 0
        return
    }
    p2580Dfs(x, y + 1)
}

fun p2580Check(x: Int, y: Int, value: Int): Boolean {
    for (i in 0 until 9) {
        if (board[x][i] == value) {
            return false
        }
    }

    for (i in 0 until 9) {
        if (board[i][y] == value) {
            return false
        }
    }

    val startRow = (x / 3) * 3
    val startCol = (y / 3) * 3
    for (i in startRow until startRow + 3) {
        for (j in startCol until startCol + 3) {
            if (board[i][j] == value) {
                return false
            }
        }
    }

    return true
}