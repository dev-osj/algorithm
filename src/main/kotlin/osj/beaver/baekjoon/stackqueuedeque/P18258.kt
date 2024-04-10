package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 1004ms 326856kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val queue = IntArray(n)
    var front = 0
    var rear = 0

    val stringBuilder = StringBuilder()
    repeat(n) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        val command = stringTokenizer.nextToken()
        when(command) {
            "push" -> {
                queue[rear++] = stringTokenizer.nextToken().toInt()
            }
            "pop" -> {
                if (front == rear) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(queue[front++])
                }
            }
            "size" -> {
                stringBuilder.appendLine(rear-front)
            }
            "empty" -> {
                val result = if (rear == front) {
                    1
                } else {
                    0
                }
                stringBuilder.appendLine(result)
            }
            "front" -> {
                if (front == rear) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(queue[front])
                }
            }
            "back" -> {
                if (rear == front) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(queue[rear-1])
                }

            }
        }
    }
    println(stringBuilder)
}