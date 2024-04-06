package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

// 92ms 12412kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    repeat(n) {
        var count = 0
        val line = reader.readLine()
        line.forEach {
            if (it == '(') {
                count++
            } else {
                count--
                if (count < 0) {
                    writer.write("NO\n")
                    return@repeat
                }
            }
        }
        val result = if (count == 0) "YES" else "NO"
        writer.write("$result\n")
    }
    writer.close()
    reader.close()
}

// 92ms 12476kb
@Suppress("Unused")
fun p9012UseStack() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    repeat(n) {
        val stack = Stack<Char>()
        val line = reader.readLine()
        line.forEach {
            if (it == '(') {
                stack.add(it)
            } else {
                if (stack.isEmpty()) {
                    writer.write("NO\n")
                    return@repeat
                }
                stack.pop()
            }
        }
        val result = if (stack.isEmpty()) "YES" else "NO"
        writer.write("$result\n")
    }
    writer.close()
    reader.close()
}