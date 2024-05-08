package osj.beaver.baekjoon.dynamicprogramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 252ms 26864kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var stringTokenizer: StringTokenizer
    var a: Int
    var b: Int
    var c: Int

    val array = Array(21) { Array(21) { IntArray(21) } }
    val stringBuilder = StringBuilder()

    while (true) {
        stringTokenizer = StringTokenizer(reader.readLine())
        a = stringTokenizer.nextToken().toInt()
        b = stringTokenizer.nextToken().toInt()
        c = stringTokenizer.nextToken().toInt()

        if (a == -1 && b == -1 && c == -1) {
            break
        }

        stringBuilder.appendLine("w($a, $b, $c) = ${p9184(array,a,b,c)}")
    }
    println(stringBuilder)
}

fun p9184(array: Array<Array<IntArray>>, a: Int, b:Int, c:Int): Int {
    if (a <= 0 || b <= 0 || c <= 0) {
        return 1
    } else if (a > 20 || b > 20 || c > 20) {
         return p9184(array, 20, 20, 20)
    } else if (array[a][b][c] != 0) {
        return array[a][b][c]
    } else if (b in (a + 1)..<c) {
        array[a][b][c] = p9184(array, a, b, c-1) + p9184(array, a, b-1, c-1) - p9184(array, a, b-1, c)
        return array[a][b][c]
    } else {
        array[a][b][c] = p9184(array, a - 1, b, c) + p9184(array, a-1, b-1, c) + p9184(array, a-1, b, c-1) - p9184(array, a-1, b-1, c-1)
        return array[a][b][c]
    }
}